package com.design.pattern.creational.factory.simpleFactory.domain;

public class Warrior implements Hero {
    @Override
    public void attack() {
        System.out.println("Use sword to attack");
    }
}
