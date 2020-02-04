package com.design.pattern.creational.factory.abstractFactory.domain;

public class FireMagician implements Hero {
    @Override
    public void attack() {
        System.out.println("Use fire ball to attack");
    }
}
