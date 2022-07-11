package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import be.bf.labo.exceptions.WrongFoodException;

public class ClownFish extends Fish implements ICarnivore {

    public ClownFish() {
        super();
    }

    public ClownFish(String name, Sex sex) {
        super(name,sex);
    }

    @Override
    public void eat(Fish fish) {
        this.heal();
        fish.getEaten();
    }

    @Override
    public void heal() {
        this.setHp(getHp()+5);
    }

    @Override
    public <T extends LivingBeing> void eat(T food) throws WrongFoodException {
        if(isHungry()) {
            if(food instanceof Fish fish) {
                this.eat(fish);
            }
        }
    }

    public static class Builder extends CarnivoreFish.Builder {
        public Fish build() {
            Fish fish = new ClownFish();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }
}
