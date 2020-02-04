package com.design.pattern.creational.factory.abstractFactory;

import com.design.pattern.creational.factory.abstractFactory.domain.*;

public class IceHeroFactory implements HeroFactory {
    @Override
    public Magician makeMagician() {
        return new IceMagician();
    }

    @Override
    public Warrior makeWarrior() {
        return new IceWarrior();
    }
}
