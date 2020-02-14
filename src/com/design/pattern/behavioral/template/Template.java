package com.design.pattern.behavioral.template;

interface AttackMethod {
    default void attack() {
        pickUpWeapon();
        moveForward();
        hitEnemy();
        putDownWeapon();
    };

    void pickUpWeapon();
    void moveForward();
    void hitEnemy();
    void putDownWeapon();
}

class MagicianAttack implements AttackMethod {

    @Override
    public void pickUpWeapon() {
        System.out.println("Pick up a stick");
    }

    @Override
    public void moveForward() {
        System.out.println("Move slowly");
    }

    @Override
    public void hitEnemy() {
        System.out.println("Use stick to hit the enemy");
    }

    @Override
    public void putDownWeapon() {
        System.out.println("Put down the stick");
    }
}

class WarriorAttack implements AttackMethod {

    @Override
    public void pickUpWeapon() {
        System.out.println("Pick up a sword");
    }

    @Override
    public void moveForward() {
        System.out.println("Move slowly");
    }

    @Override
    public void hitEnemy() {
        System.out.println("Use sword to hit the enemy");
    }

    @Override
    public void putDownWeapon() {
        System.out.println("Put down the sword");
    }
}

class Hero {
    public void attack(AttackMethod attackMethod) {
        attackMethod.attack();
    }
}

public class Template {

    public static void main(String[] args) {
        AttackMethod magicianAttack = new MagicianAttack();
        AttackMethod warriorAttack = new WarriorAttack();
        Hero hero = new Hero();
        hero.attack(magicianAttack);
        hero.attack(warriorAttack);
    }
}
