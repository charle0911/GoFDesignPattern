package com.design.pattern.creational.factory.abstractFactory;

import java.util.Scanner;

public class FactoryProto {
    public static void main(String[] args) {
        HeroFactory factory = null;
        Scanner sc = new Scanner(System.in);
        String attribute = sc.next();

        if (attribute.equals("fire")) {
            factory = new FireHeroFactory();
        } else if (attribute.equals("ice")){
            factory = new IceHeroFactory();
        }

        String hero = sc.next();
        if (hero.equals("magician")) {
            factory.makeMagician().magicAttack();
        } else if (hero.equals("warrior")) {
            factory.makeWarrior().swordAttack();
        }
    }
}
