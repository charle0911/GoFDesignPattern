package com.design.pattern.structural;

interface Hero {
    void attack();
}

class Warrior implements Hero {

    @Override
    public void attack() {
        System.out.println("Warrior attck");
    }
}


abstract class IntermediateWarriorDecorator implements Hero{
    private Hero warrior;

    public IntermediateWarriorDecorator(Hero warrior) {
        this.warrior = warrior;
    }

    public void originalAttack() {
        warrior.attack();
    }
}

class Knight extends IntermediateWarriorDecorator {

    public Knight(Hero warrior) {
        super(warrior);
    }

    @Override
    public void attack() {
        super.originalAttack();
        System.out.println("Knight attack");
    }
}

class Crusader extends IntermediateWarriorDecorator {

    public Crusader(Hero warrior) {
        super(warrior);
    }

    @Override
    public void attack() {
        super.originalAttack();
        System.out.println("Crusader attack");
    }
}



public class Decorator {
    public static void main(String[] args) {
        Hero knight = new Knight(new Warrior());
        Hero crusader = new Crusader(new Warrior());

        knight.attack();
        crusader.attack();
    }
}
