package com.design.pattern.creational.factory.abstractFactory;

import com.design.pattern.creational.factory.abstractFactory.domain.FireMagician;
import com.design.pattern.creational.factory.abstractFactory.domain.Hero;
import com.design.pattern.creational.factory.abstractFactory.domain.IceMagician;
import com.design.pattern.creational.factory.abstractFactory.domain.IceWarrior;

public class IceHeroFactory implements HeroFactory {
    @Override
    public Hero makeMagician() {
        return new IceMagician();
    }

    @Override
    public Hero makeWarrior() {
        return new IceWarrior();
    }
}
