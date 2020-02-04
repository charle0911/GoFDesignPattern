package com.design.pattern.creational.factory.simpleFactory.domain;

public class Magician implements Hero {
    @Override
    public void attack() {
        System.out.println("Use magic to attack");
    }
}
