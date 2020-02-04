package com.design.pattern.creational.factory.abstractFactory.domain;

public class IceMagician implements Hero {

    @Override
    public void attack() {
        System.out.println("Use ice ball to attack");
    }
}
