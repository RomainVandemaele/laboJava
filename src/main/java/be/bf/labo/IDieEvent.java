package be.bf.labo;

import be.bf.labo.models.Fish;
import be.bf.labo.models.LivingBeing;

@FunctionalInterface
public interface IDieEvent {
    public void invoke(LivingBeing fish);
}
