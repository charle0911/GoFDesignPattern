package com.design.pattern.creational.factory.factoryMethod;

import com.design.pattern.creational.factory.factoryMethod.domain.Hero;

public interface HeroCreator<TYPE, HERO extends Hero> {
    HERO createHero(TYPE type);
}
