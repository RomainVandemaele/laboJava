package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.security.PublicKey;
import java.security.SecureRandom;



public abstract class Fish extends LivingBeing implements IFish {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("name='").append(name).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", pv=").append(getHp());
        sb.append('}');
        return sb.toString();
    }

    @Getter
    private String name;
    @Getter @Setter
    private Sex sex;

    public Fish() {
        SecureRandom sr = new SecureRandom();
        this.setName( "P" + sr.nextInt(1,100) ) ;
        this.setSex(sr.nextBoolean()?Sex.MALE:Sex.FEMALE);
    }

    public Fish(String name, Sex sex) {
        this.setName(name);
        this.setSex(sex);
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract <T extends LivingBeing> void eat(T food);


    @Override
    public void getEaten() {
        this.setHp(getHp()-4);
        if(!isAlive()) {
            this.triggerDieEvent();
        }
    }

    @Override
    public void triggerTurnEvent() {
        this.setHp(this.getHp()-1);
    }

    public abstract static class Builder extends LivingBeing.Builder {

        protected String name;
        protected Sex sex;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public abstract LivingBeing build();


    }

}
