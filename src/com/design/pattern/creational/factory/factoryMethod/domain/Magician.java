package com.design.pattern.creational.factory.factoryMethod.domain;

public abstract class Magician implements Hero {
    abstract void magicAttack();

    @Override
    public void attack() {
        System.out.println("Use magic to attack");
    }

}
