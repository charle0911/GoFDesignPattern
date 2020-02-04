package com.design.pattern.creational.factory.abstractFactory.domain;

public class IceWarrior implements Hero {
    @Override
    public void attack() {
        System.out.println("Use ice sword to attack");
    }
}
