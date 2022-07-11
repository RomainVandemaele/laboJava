package be.bf.labo.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    @Getter
    List<IFish> fishs = new ArrayList<>();
    @Getter
    List<IAlgua> alguaes = new ArrayList<>();

    public int nTurn = 0;

    public Aquarium addFish(Fish fish) {
        if(fish == null) return this;
        this.fishs.add(fish);
        return this;
    }

    public Aquarium addAlgua(Algua algua) {
        if(algua == null) return this;
        this.alguaes.add(algua);
        return this;
    }

    public void turn() {
        System.out.printf("There is %d alguaes\n",this.alguaes.size());
        fishs.forEach(System.out::println);
        nTurn++;
    }

}
