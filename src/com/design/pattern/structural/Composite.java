package com.design.pattern.structural;

import java.util.ArrayList;

abstract class Group {
    private String name;

    Group(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public abstract void print();
    public abstract void addGroup(Group group);
}

class Team extends Group {

    Team(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

    @Override
    public void addGroup(Group group) {

    }
}

class League extends Group {

    private ArrayList<Group> groupList = new ArrayList<>();

    League(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(getName());
        for(Group group : groupList) {
            group.print();
        }
    }

    @Override
    public void addGroup(Group group) {
        groupList.add(group);
    }
}


public class Composite {

    public static void main(String[] args) {
        Group newLeague = new League("Hero League");
        Group firstTeam = new Team("First Team");
        Group secondTeam = new Team("Second Team");
        newLeague.addGroup(firstTeam);
        newLeague.addGroup(secondTeam);
        newLeague.print();
    }
}
