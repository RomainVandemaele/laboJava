package be.bf.labo.models;

import be.bf.labo.exceptions.WrongFoodException;

public abstract class CarnivoreFish extends Fish implements  ICarnivoreFish {

    @Override
    public <T extends LivingBeing> void eat(T food) throws WrongFoodException {
        if(food instanceof Fish f) {
            food = null;
        }else {
            throw new WrongFoodException();
        }
    }

}
