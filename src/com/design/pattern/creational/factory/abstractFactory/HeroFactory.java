package com.design.pattern.creational.factory.abstractFactory;

import com.design.pattern.creational.factory.abstractFactory.domain.Hero;
import com.design.pattern.creational.factory.abstractFactory.domain.Magician;
import com.design.pattern.creational.factory.abstractFactory.domain.Warrior;

public interface HeroFactory {
    Magician makeMagician();
    Warrior makeWarrior();
}
