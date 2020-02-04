package com.design.pattern.creational.factory.simpleFactory;

import com.design.pattern.creational.factory.simpleFactory.domain.Hero;
import com.design.pattern.creational.factory.simpleFactory.domain.HeroType;
import com.design.pattern.creational.factory.simpleFactory.domain.Magician;
import com.design.pattern.creational.factory.simpleFactory.domain.Warrior;

public class HeroFactory {
    public Hero makeHero(HeroType heroType) {
        if (heroType.equals(HeroType.MAGICIAN)) {
            return new Magician();
        } else {
            return new Warrior();
        }
    }

    public static void main(String[] args) {
        HeroFactory heroFactory = new HeroFactory();
        Hero hero = heroFactory.makeHero(HeroType.MAGICIAN);
        hero.attack();
    }
}
