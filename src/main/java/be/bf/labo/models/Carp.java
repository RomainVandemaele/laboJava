package be.bf.labo.models;

public class Carp extends HerbivoreFish implements IHerbivoreFish {
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
