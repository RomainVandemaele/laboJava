package be.bf.labo.models;

public class Algua extends LivingBeing implements IAlgua {

    @Override
    public void heal() {}

    @Override
    public void getEaten() {
        this.setHp(this.getHp()-2);
        if(getHp() <=0) {
            this.triggerDieEvent();
        }
    }
}
