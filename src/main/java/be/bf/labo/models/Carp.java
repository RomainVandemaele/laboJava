package be.bf.labo.models;

public class Carp extends HerbivoreFish implements IHerbivore {
    @Override
    public <T extends LivingBeing> void eat(T food) {

    }

    @Override
    public void eat(Algua algua) {

    }

    @Override
    public void heal() {

    }

    public static class Builder extends HerbivoreFish.Builder {
        public Fish build() {
            Fish fish = new Carp();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }

}
