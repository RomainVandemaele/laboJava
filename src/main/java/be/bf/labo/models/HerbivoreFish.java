package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import be.bf.labo.exceptions.WrongFoodException;

public abstract class HerbivoreFish extends Fish implements IHerbivoreFish {


    @Override
    public void heal() {
        this.setHp(getHp()+3);
    }

    public HerbivoreFish() {
        super();
    }

    public HerbivoreFish(String name, Sex sex) {
        super(name,sex);
    }

    @Override
    public <T extends LivingBeing> void eat(T food) throws WrongFoodException {
        if(isHungry()) {
            if(food instanceof Algua algua) {
                algua = null;
            }else {
                throw new WrongFoodException();
            }
        }
    }


    public abstract static class Builder extends Fish.Builder {
        public abstract Fish build();
    }
}
