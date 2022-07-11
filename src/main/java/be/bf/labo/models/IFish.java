package be.bf.labo.models;

public interface IFish {

    public int getHp();

    public abstract<T extends LivingBeing> void eat (T food);
    default public boolean isHungry() {
        return this.getHp() <= 5;
    }

}
