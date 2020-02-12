package com.design.pattern.structural.proxy;


import java.util.HashSet;
import java.util.Set;

interface Team {
    boolean join(String name);

    boolean quit(String name);
}

class League implements Team {

    private Set<String> heroSet = new HashSet<>();

    @Override
    public boolean join(String name) {
        return heroSet.add(name);
    }

    @Override
    public boolean quit(String name) {
        return heroSet.remove(name);
    }

    public boolean isExist(String name) {
        return heroSet.contains(name);
    }
}

class LeagueProxy implements Team {

    League league = new League();

    @Override
    public boolean join(String name) {
        if (league.isExist(name)) {
            return false;
        }
        return league.join(name);
    }

    @Override
    public boolean quit(String name) {
        if (league.isExist(name)) {
            return league.quit(name);
        }
        return false;
    }
}


public class Proxy {

    public static void main(String[] args) {
        Team league = new LeagueProxy();

        System.out.println(league.join("HeroA"));
        System.out.println(league.join("HeroB"));
        System.out.println(league.join("HeroA"));

        System.out.println(league.quit("HeroC"));
    }
}
