package be.bf.labo.models;

public class Algua extends LivingBeing implements IAlgua {

    public Algua() {
        super();
    }


    @Override
    public void heal() {}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Algua{");
        sb.append("hp=").append(this.getHp());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void getEaten() {
        this.setHp(this.getHp()-2);
        if(getHp() <=0) {
            this.triggerDieEvent();
        }
    }

    @Override
    public void triggerTurnEvent() {
        this.setHp(this.getHp()+1);
    }
}
