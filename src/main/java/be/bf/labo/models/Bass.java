package be.bf.labo.models;

public class Bass extends HerbivoreFish implements IHerbivore {

    public static class Builder extends HerbivoreFish.Builder {
        public Fish build() {
            Fish fish = new Bass();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }
}
