package com.design.pattern.structural;


class GameA {
    public String getHero(String heroName) {
        return "Game A hero";
    }
}

class GameB {
    public String getHero(String heroName) {
        return "Game B hero";
    }
}

class GameFacade {
    public String getHero(String heroName, String gameType) {
        if (gameType.equals("A")) {
            return new GameA().getHero(heroName);
        } else {
            return new GameB().getHero(heroName);
        }
    }
}

public class Facade {
    public static void main(String[] args) {
        GameFacade gameFacade = new GameFacade();
        System.out.println(gameFacade.getHero("Warrior", "A"));
    }
}
