package be.bf.labo;

import be.bf.labo.models.Fish;

@FunctionalInterface
public interface ITurnEvent {
    public void evolve(Fish fish);
}
