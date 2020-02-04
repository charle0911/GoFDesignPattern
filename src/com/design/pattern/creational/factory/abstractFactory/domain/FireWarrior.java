package com.design.pattern.creational.factory.abstractFactory.domain;

public class FireWarrior implements Warrior {

    @Override
    public void swordAttack() {
        System.out.println("Use fire sword to attack");
    }
}
