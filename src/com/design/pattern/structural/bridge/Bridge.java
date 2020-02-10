package com.design.pattern.structural.bridge;

interface HeroAction {
    void kick();

    void slash();

    void beat();
}

class FireHeroAction implements HeroAction {

    @Override
    public void kick() {
        System.out.println("Fire kick");
    }

    @Override
    public void slash() {
        System.out.println("Fire slash");
    }

    @Override
    public void beat() {
        System.out.println("Fire beat");
    }
}

class IceHeroAction implements HeroAction {

    @Override
    public void kick() {
        System.out.println("Ice kick");
    }

    @Override
    public void slash() {
        System.out.println("Ice slash");
    }

    @Override
    public void beat() {
        System.out.println("Ice beat");
    }
}

abstract class Hero {
    private HeroAction heroAction;

    Hero() {
    }

    Hero(HeroAction heroAction) {
        this.heroAction = heroAction;
    }

    public void setHeroAction(HeroAction heroAction) {
        this.heroAction = heroAction;
    }

    public HeroAction getHeroAction() {
        return heroAction;
    }

    abstract void kick();

    abstract void attack();
}

class Magician extends Hero {

    Magician(HeroAction heroAction) {
        super(heroAction);
    }

    @Override
    void kick() {
        getHeroAction().kick();
    }

    @Override
    void attack() {
        getHeroAction().beat();
    }
}

class Warrior extends Hero {

    Warrior(HeroAction heroAction) {
        super(heroAction);
    }

    @Override
    void kick() {
        getHeroAction().kick();
    }

    @Override
    void attack() {
        getHeroAction().slash();
    }
}

public class Bridge {

    public static void main(String[] args) {
        Hero warrior = new Warrior(new IceHeroAction());
        Hero magician = new Magician(new FireHeroAction());
        warrior.attack();
        magician.attack();
    }
}
