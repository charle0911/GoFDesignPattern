package com.design.pattern.structural.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Weapon {
    ArrayList<Diamond> diamonds = new ArrayList<>();
    public void addDiamond(Diamond diamond) {
        diamonds.add(diamond);
    }
    abstract void attack();
}

class Sword extends Weapon {
    @Override
    void attack() {
        System.out.println("Sword attack");
        diamonds.forEach((x) -> {
            System.out.println("Use " + x.name + " to attack");
        });
    }
}

class Diamond {
    String name;

    public Diamond(String name) {
        this.name = name;
    }
}

class DiamondFactory {
    private static Map<String, Diamond> diamondMap = new HashMap<>();

    public Diamond getDiamond(String diamondName) {
        if (diamondMap.containsKey(diamondName)) {
            System.out.println("Without create " + diamondName + " diamond");
            return diamondMap.get(diamondName);
        } else {
            Diamond newDiamond = new Diamond(diamondName);
            diamondMap.put(diamondName, newDiamond);
            return newDiamond;
        }
    }
}

public class Flyweight {

    public static void main(String[] args) {
        Weapon sword = new Sword();
        DiamondFactory diamondFactory = new DiamondFactory();
        sword.addDiamond(diamondFactory.getDiamond("Yellow"));
        sword.addDiamond(diamondFactory.getDiamond("Blue"));
        sword.addDiamond(diamondFactory.getDiamond("Black"));
        sword.addDiamond(diamondFactory.getDiamond("Black"));
        sword.attack();
    }
}
