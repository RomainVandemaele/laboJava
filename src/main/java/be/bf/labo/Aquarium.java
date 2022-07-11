package be.bf.labo;

import be.bf.labo.models.Algua;
import be.bf.labo.models.Fish;
import be.bf.labo.models.IHerbivore;
import be.bf.labo.models.LivingBeing;
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
        System.out.println("BEFORE TURN");
        fishes.forEach(System.out::println);

        SecureRandom sr = new SecureRandom();
        for ( Fish fish : fishes) {
            if(fish.isAlive()) {
                System.out.println(fish);
                LivingBeing food = selectTarget(fish);
                fish.eat(food);
                fish.triggerTurnEvent(); //update hp
            }
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
        if(attacker instanceof IHerbivore herbFish) {
            final int index = sr.nextInt(0,this.alguae.size());
            food = this.alguae.get(index);

            if(attacker.isHungry() ) { System.out.printf("%s eats algua\n",attacker.getName()); }

        }else  { //carnivore
            int index = sr.nextInt(0,this.fishes.size());
            food = this.fishes.get(index);
            while(attacker.getClass() == food.getClass() || attacker.equals(food)) {
                index = sr.nextInt(0,this.fishes.size());
                food = this.fishes.get(index);
            }
            if(attacker.isHungry() ) { System.out.printf("fish %s eats fish %s\n",attacker.getName(),((Fish) food).getName()); }
        }
        return food;
    }

    public void dieEvent(LivingBeing being) {
        if(being instanceof Fish fish) {
            System.out.printf("%s is dead\n",fish.getName());
            fishes = fishes.stream().filter( f -> f.isAlive() ).toList();
        }else if(being instanceof Algua algua) {
            System.out.println("One algue is dead");
            alguae = alguae.stream().filter( a -> a.isAlive() ).toList();
        }
    }

}
