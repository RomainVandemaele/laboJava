package be.bf.labo;

import be.bf.labo.enumerations.Sex;
import be.bf.labo.models.Algua;
import be.bf.labo.models.Aquarium;
import be.bf.labo.models.Fish;

public class Main {

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua())
                .addAlgua(new Algua());

//        aquarium.addFish((Fish) new Fish.Builder().name("P1").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P2").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P3").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P4").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P5").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P6").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P7").sex(Sex.MALE).build())
//                .addFish((Fish) new Fish.Builder().name("P8").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Fish.Builder().name("P9").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Fish.Builder().name("P10").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Fish.Builder().name("P11").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Fish.Builder().name("P12").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Fish.Builder().name("P13").sex(Sex.FEMALE).build())
//                .addFish((Fish) new Fish.Builder().name("P14").sex(Sex.FEMALE).build());

        aquarium.turn();

    }
}
