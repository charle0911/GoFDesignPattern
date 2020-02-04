package com.design.pattern.creational.factory.factoryMethod;

import com.design.pattern.creational.factory.factoryMethod.domain.*;

enum MagicianType {
    FIRE, ICE
}

public class MagicianCreator implements HeroCreator<MagicianType, Magician>{
    @Override
    public Magician createHero(MagicianType heroType) {
        if (MagicianType.ICE == heroType) {
            return new IceMagician();
        }
        return new FireMagician();
    }
}
