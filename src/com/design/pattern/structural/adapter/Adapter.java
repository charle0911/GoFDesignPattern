package com.design.pattern.structural.adapter;

interface Hero {
    void attack();
}

class MyHero implements Hero {

    @Override
    public void attack() {
        System.out.println("My hero attack");
    }
}

class UnionHero {
    public void touch() {
        System.out.println("Union Hero touch");
    }
}

class HeroAdapter implements Hero {

    private UnionHero unionHero = null;

    HeroAdapter(UnionHero unionHero) {
        this.unionHero = unionHero;
    }

    @Override
    public void attack() {
        unionHero.touch();
    }
}

public class Adapter {
    public static void main(String[] args) {
        Hero hero = new MyHero();
        Hero unionHero = new HeroAdapter(new UnionHero());
        hero.attack();
        unionHero.attack();
    }
}
