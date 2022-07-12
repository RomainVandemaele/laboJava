package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.annotation.processing.SupportedOptions;

@ToString(callSuper = true)
//@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Carp extends Fish implements IHerbivore {

    public Carp() {
        super();
    }

    public Carp(String name, Sex sex) {
        super(name,sex);
    }
    @Override
    public <T extends LivingBeing> void eat(T food) {
        if( isHungry() && food instanceof Algua algua) {
            this.eat(algua);
        }
    }

    @Override
    public void heal() {this.setHp(getHp()+3);}

    @Override
    public void eat(Algua algua) {
        this.heal();
        algua.getEaten();
    }

    public static class Builder extends Fish.Builder {
        public Fish build() {
            Fish fish = new Carp();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }

}
