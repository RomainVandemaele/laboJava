package be.bf.labo.exceptions;

public class WrongFoodException extends RuntimeException{

    public WrongFoodException() {
        super("The fish tried to eat wrong type of food\n");
    }
}
