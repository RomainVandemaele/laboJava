package be.bf.labo.models;

import lombok.Getter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    @Getter
    List<Fish> fishes = new ArrayList<>();
    @Getter
    List<Algua> alguae = new ArrayList<>();

    public int nTurn = 0;

    public Aquarium addFish(Fish fish) {
        if(fish == null) return this;
        fish.setDieEvent(this::dieEvent);
        this.fishes.add(fish);
        return this;
    }

    public Aquarium addAlgua(Algua algua) {
        if(algua == null) return this;
        this.alguae.add(algua);
        return this;
    }

    public void turn() {
        System.out.printf("TURN %d \n\n",nTurn);
        System.out.printf("There is %d alguaes\n",this.alguae.size());
        System.out.printf("There is %d fishes\n",this.fishes.size());
        SecureRandom sr = new SecureRandom();
        for ( Fish fish : fishes) {
            System.out.println(fish);
            fish.eat( selectTarget(fish));
            fish.triggerTurnEvent(); //update hp
        }

        for ( Algua algua : alguae) {
            System.out.println(algua);
            algua.triggerTurnEvent(); //update hp
        }

        //fishes.forEach(System.out::println);
        nTurn++;
    }

    public LivingBeing selectTarget(Fish attacker) {
        SecureRandom sr = new SecureRandom();
        LivingBeing food;
        if(attacker instanceof HerbivoreFish herbFish) {
            final int index = sr.nextInt(0,this.alguae.size());
            food = this.alguae.get(index);
        }else  { //carnivore
            int index = sr.nextInt(0,this.fishes.size());
            food = this.fishes.get(index);
            while(attacker.getClass() == food.getClass() || attacker.equals(food)) {
                index = sr.nextInt(0,this.fishes.size());
                food = this.fishes.get(index);
            }
        }
        return food;
    }

    public void dieEvent(LivingBeing being) {
        if(being instanceof Fish fish) {
            System.out.printf("%s is dead",fish.getName());
            fishes = fishes.stream().filter( f -> !f.getName().equals(fish.getName())).toList();
        }else if(being instanceof Algua algua) {
            System.out.println("One algue is dead");
            fishes = fishes.stream().filter( a -> a.equals(algua) ).toList();
        }
    }

}
