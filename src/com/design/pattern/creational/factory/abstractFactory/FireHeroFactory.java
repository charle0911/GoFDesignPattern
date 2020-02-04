package com.design.pattern.creational.factory.abstractFactory;

import com.design.pattern.creational.factory.abstractFactory.domain.*;

public class FireHeroFactory implements HeroFactory {
    @Override
    public Magician makeMagician() {
        return new FireMagician();
    }

    @Override
    public Warrior makeWarrior() {
        return new FireWarrior();
    }
}
