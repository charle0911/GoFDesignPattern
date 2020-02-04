package com.design.pattern.creational.factory.abstractFactory;

import com.design.pattern.creational.factory.abstractFactory.domain.FireMagician;
import com.design.pattern.creational.factory.abstractFactory.domain.FireWarrior;
import com.design.pattern.creational.factory.abstractFactory.domain.Hero;

public class FireHeroFactory implements HeroFactory {
    @Override
    public Hero makeMagician() {
        return new FireMagician();
    }

    @Override
    public Hero makeWarrior() {
        return new FireWarrior();
    }
}
