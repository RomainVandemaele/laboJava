package be.bf.labo;

import be.bf.labo.enumerations.Sex;
import be.bf.labo.models.*;

public class Main {

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua());

        Fish f = new Carp();
        System.out.println(f.getName());

        aquarium.addFish((Fish) new Tuna.Builder().name("P1").sex(Sex.MALE).build())
                .addFish((Fish) new Sole.Builder().name("P2").sex(Sex.MALE).build())
                .addFish((Fish) new Grouper.Builder().name("P3").sex(Sex.MALE).build())
                .addFish((Fish) new ClownFish.Builder().name("P4").sex(Sex.MALE).build());
//                .addFish((Fish) new Carp.Builder().name("P5").sex(Sex.MALE).build())
//                .addFish((Fish) new Bass.Builder().name("P6").sex(Sex.MALE).build())
//                .addFish((Fish) new Tuna.Builder().name("P8").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Sole.Builder().name("P9").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Grouper.Builder().name("P10").sex(Sex.FEMALE).build())
//                .addFish((Fish) new ClownFish.Builder().name("P11").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Carp.Builder().name("P12").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Bass.Builder().name("P13").sex(Sex.FEMALE).build());

        for (int i=0;i<20;++i) {
            aquarium.turn();
        }
    }
}
