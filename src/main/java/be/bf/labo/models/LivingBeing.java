package be.bf.labo.models;

import lombok.Getter;
import lombok.Setter;

public abstract class LivingBeing {
    public static final int MAX_HP = 10;
    @Getter @Setter
    private int hp;

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
