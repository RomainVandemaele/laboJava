package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public abstract class Fish extends LivingBeing implements IFish {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Sex sex;

    public Fish(String name, Sex sex) {
        this.setName(name);
        this.setSex(sex);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract <T extends LivingBeing> void eat(T food);


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
