package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import be.bf.labo.exceptions.WrongFoodException;


public abstract class CarnivoreFish extends Fish implements ICarnivore {
    @Override
    public void eat(Fish fish) {

    }

    public CarnivoreFish() {
        super();
    }



    public CarnivoreFish(String name, Sex sex) {
        super(name,sex);
    }

    @Override
    public void heal() {
        this.setHp(getHp()+5);
    }

    @Override
    public <T extends LivingBeing> void eat(T food) throws WrongFoodException {
        if(isHungry()) {
            if(food instanceof Fish fish) {
                //fish = null;
                this.heal();
                fish.getEaten();
            }else {
                throw new WrongFoodException();
            }
        }
    }

    public abstract static class Builder extends Fish.Builder {
        public abstract Fish build();
    }

}
