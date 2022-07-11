package be.bf.labo.models;

import be.bf.labo.IDieEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class LivingBeing {
    @Setter
    public IDieEvent dieEvent;
    public static final int START_HP = 10;
    @Getter
    private int hp = START_HP;

    protected LivingBeing setHp(int hp) {
        if(hp <0 ) return this;
        this.hp = hp;
        return this;
    }

    protected void triggerDieEvent() {
        if(this.dieEvent!=null) {
            dieEvent.invoke(this);
        }
    }

    public boolean isAlive() {
        return hp>=0;
    }

    public abstract void heal(); //heal after eating
    public abstract void getEaten();

    public abstract void triggerTurnEvent();

    public static abstract class Builder {
        protected int hp = LivingBeing.START_HP;

        public Builder hp(int hp) {
            if(hp < 0) return this;
            this.hp = hp;
            return this;
        }

        public abstract LivingBeing build();

    }

}
