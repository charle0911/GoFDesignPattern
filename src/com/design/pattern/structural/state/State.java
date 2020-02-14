package com.design.pattern.structural.state;

interface HeroState {
    void run();
    void useSkill();
    void attack();
}

class PetrochemicalState implements HeroState {

    @Override
    public void run() {
        System.out.println("Your are a stone so you can't do anything");
    }

    @Override
    public void useSkill() {
        System.out.println("Your are a stone so you can't do anything");
    }

    @Override
    public void attack() {
        System.out.println("Your are a stone so you can't do anything");
    }
}

class CursedState implements HeroState {

    @Override
    public void run() {
        System.out.println("You are running");
    }

    @Override
    public void useSkill() {
        System.out.println("Your are cursed so you can't use skill");
    }

    @Override
    public void attack() {
        System.out.println("Your are attacking");
    }
}

class NormalState implements HeroState {

    @Override
    public void run() {
        System.out.println("You are running");
    }

    @Override
    public void useSkill() {
        System.out.println("Your are using skill");
    }

    @Override
    public void attack() {
        System.out.println("Your are attacking");
    }
}

class Hero {

    HeroState heroState;

    public void attack() {
        heroState.attack();
    }

    public void run() {
        heroState.run();
    }

    public void useSkill() {
        heroState.useSkill();
    }

    public void setState(HeroState state) {
        this.heroState = state;
    }
}

class HeroActionService {
    public void doAllAction(Hero hero) {
        hero.attack();
        hero.run();
        hero.useSkill();
    }
}

public class State {
    public static void main(String[] args) {
        Hero hero = new Hero();
        HeroActionService heroActionService = new HeroActionService();
        System.out.println("Normal state");
        hero.setState(new NormalState());
        heroActionService.doAllAction(hero);
        hero.setState(new CursedState());
        heroActionService.doAllAction(hero);
        hero.setState(new PetrochemicalState());
        heroActionService.doAllAction(hero);
    }
}
