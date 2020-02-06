package com.design.pattern.creational.prototype;

class Hero implements Cloneable {
    //Prototype

    private String weapon;

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class HeroCam {
    // Prototype registry
    public Hero makeHero() {
        return new Hero();
    }

    public Hero cloneHero(Hero hero) throws CloneNotSupportedException {
        return (Hero) hero.clone();
    }
}

public class Prototype {

    public static void main(String[] args) {
        HeroCam heroCam = new HeroCam();
        try {
            Hero hero = heroCam.makeHero();
            hero.setWeapon("Magic");
            Hero newHero = heroCam.cloneHero(hero);
            System.out.println(hero.getWeapon());
            System.out.println(newHero.getWeapon());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
