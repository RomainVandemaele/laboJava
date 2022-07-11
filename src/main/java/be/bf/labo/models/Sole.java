package be.bf.labo.models;

public class Sole extends HerbivoreFish implements IHerbivore {

    public static class Builder extends HerbivoreFish.Builder {
        public Fish build() {
            Fish fish = new Sole();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }
}
