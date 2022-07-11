package be.bf.labo.models;

public class ClownFish extends CarnivoreFish implements ICarnivore {

    public static class Builder extends CarnivoreFish.Builder {
        public Fish build() {
            Fish fish = new ClownFish();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }
}
