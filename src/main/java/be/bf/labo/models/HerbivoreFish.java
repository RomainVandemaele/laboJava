package be.bf.labo.models;

import be.bf.labo.exceptions.WrongFoodException;

public abstract class HerbivoreFish extends Fish implements IHerbivoreFish {

    @Override
    public void eat(Algua plant) {
        plant = null;
    }


    @Override
    public <T extends LivingBeing> void eat(T food) throws WrongFoodException {
        if(food instanceof Algua) {
            food = null;
        }else {
            throw new WrongFoodException();
        }
    }
}
