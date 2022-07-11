package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import be.bf.labo.exceptions.WrongFoodException;
import lombok.NoArgsConstructor;


public abstract class CarnivoreFish extends Fish implements  ICarnivoreFish {

    public CarnivoreFish() {
        super();
    }

    @Override
    public void heal() {
        this.setHp(getHp()+5);
    }

    public CarnivoreFish(String name, Sex sex) {
        super(name,sex);
    }

    @Override
    public <T extends LivingBeing> void eat(T food) throws WrongFoodException {
        if(isHungry()) {
            if(food instanceof Fish fish) {
                fish = null;
            }else {
                throw new WrongFoodException();
            }
        }
    }

    public abstract static class Builder extends Fish.Builder {
        public abstract Fish build();
    }

}
