package com.design.pattern.creational.factory.abstractFactory.domain;

public class FireMagician implements Magician {
    @Override
    public void magicAttack() {
        System.out.println("Use fire ball to attack");
    }
}
