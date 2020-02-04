package com.design.pattern.creational.factory.abstractFactory.domain;

public class FireWarrior implements Hero {

    @Override
    public void attack() {
        System.out.println("Use fire sword to attack");
    }
}
