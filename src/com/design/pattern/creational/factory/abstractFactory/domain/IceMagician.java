package com.design.pattern.creational.factory.abstractFactory.domain;

public class IceMagician implements Magician {

    @Override
    public void magicAttack() {
        System.out.println("Use ice ball to attack");
    }
}
