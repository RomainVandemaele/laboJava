package be.bf.labo.models;

import be.bf.labo.enumerations.Sex;

public class Bass extends Fish implements IHerbivore {

    public Bass() {
        super();
    }

    public Bass(String name, Sex sex) {
        super(name,sex);
    }


    @Override
    public <T extends LivingBeing> void eat(T food) {
        if(isHungry() && food instanceof Algua algua) {
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
            Fish fish = new Bass();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }
}
