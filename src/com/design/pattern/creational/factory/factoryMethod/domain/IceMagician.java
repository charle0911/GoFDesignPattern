package com.design.pattern.creational.factory.factoryMethod.domain;

public class IceMagician implements Magician {

    @Override
    public void magicAttack() {
        System.out.println("Use ice ball to attack");
    }
}
