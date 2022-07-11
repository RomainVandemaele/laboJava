package be.bf.labo.models;

import be.bf.labo.IDieEvent;
import lombok.Getter;
import lombok.Setter;

public abstract class LivingBeing {
    @Setter
    public IDieEvent dieEvent;
    public static final int MAX_HP = 10;
    @Getter
    private int hp;

    protected LivingBeing setHp(int hp) {
        this.hp = hp>=MAX_HP?MAX_HP:hp;
        return this;
    }

    protected void triggerDieEvent() {
        if(this.dieEvent!=null) {
            dieEvent.invoke(this);
        }
    }

    public abstract void heal(); //heal after eating
    public abstract void getEaten();

    public static abstract class Builder {
        protected int hp = LivingBeing.MAX_HP;

        public Builder hp(int hp) {
            if(hp < 0) return this;
            this.hp = hp;
            return this;
        }

        public abstract LivingBeing build();

    }



}
