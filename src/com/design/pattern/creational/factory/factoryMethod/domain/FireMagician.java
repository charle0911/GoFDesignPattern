package com.design.pattern.creational.factory.factoryMethod.domain;

public class FireMagician implements Magician {
    @Override
    public void magicAttack() {
        System.out.println("Use fire ball to attack");
    }
}
