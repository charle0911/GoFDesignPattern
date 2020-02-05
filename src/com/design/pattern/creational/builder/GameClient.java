package com.design.pattern.creational.builder;


import java.util.Scanner;

class Hero {
    String hair;
    String body;

    public void setHair(String hair) {
        this.hair = hair;
    }

    public void setBody(String body) {
        this.body = body;
    }
}


abstract class HeroBuilder {
    protected Hero hero;

    public void createHero() {
        hero = new Hero();
    }

    public Hero getHero() {
        return hero;
    }

    public abstract void setHair();

    public abstract void setBody();
}

class NormalHeroBuilder extends HeroBuilder {

    @Override
    public void setHair() {
        hero.setHair("normal");
    }

    @Override
    public void setBody() {
        hero.setBody("normal");
    }
}

class HighHeroBuilder extends HeroBuilder {
    @Override
    public void setHair() {
        hero.setHair("high");
    }

    @Override
    public void setBody() {
        hero.setBody("high");
    }
}

class Camp {
    private HeroBuilder heroBuilder;

    public void setHeroBuilder(HeroBuilder heroBuilder) {
        this.heroBuilder = heroBuilder;
    }

    public Hero getHero() {
        return heroBuilder.getHero();
    }

    public void constructHero() {
        heroBuilder.createHero();
        heroBuilder.setBody();
        heroBuilder.setHair();
    }
}

public class GameClient {

    public static void main(String[] args) {
        Camp heroCamp = new Camp();
        HeroBuilder heroBuilder = null;
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        if (type.equals("Normal")) {
            heroBuilder = new NormalHeroBuilder();
        } else if (type.equals("High")) {
            heroBuilder = new HighHeroBuilder();
        }

        if (heroBuilder != null) {
            heroCamp.setHeroBuilder(heroBuilder);
            heroCamp.constructHero();
            Hero hero = heroCamp.getHero();
            System.out.println(hero.body);
            System.out.println(hero.hair);
        }

    }
}
