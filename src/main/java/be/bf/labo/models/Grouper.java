package be.bf.labo.models;

public class Grouper extends CarnivoreFish implements ICarnivore {


    public static class Builder extends CarnivoreFish.Builder {
        public Fish build() {
            Fish fish = new Grouper();
            fish.setHp(this.hp);
            fish.setSex(this.sex);
            fish.setName(this.name);
            return fish;
        }
    }
}
