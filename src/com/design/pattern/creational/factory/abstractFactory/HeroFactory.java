package com.design.pattern.creational.factory.abstractFactory;

import com.design.pattern.creational.factory.abstractFactory.domain.Hero;

public interface HeroFactory {
    Hero makeMagician();
    Hero makeWarrior();
}
