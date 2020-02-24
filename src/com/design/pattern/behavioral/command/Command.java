package com.design.pattern.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

interface SkillCommand {
    void execute();
}

class Poison implements SkillCommand {

    @Override
    public void execute() {
        System.out.println("Poison your enemy");
    }
}

class Bless implements SkillCommand {

    @Override
    public void execute() {
        System.out.println("Bless yourself");
    }
}

class Attack implements SkillCommand {

    @Override
    public void execute() {
        System.out.println("Attack your enemy");
    }
}

class UserAction {
    private Queue<SkillCommand> combo = new LinkedList<>();

    public void setSkill(SkillCommand skill) {
        combo.add(skill);
    }

    public void useCombo() {
        for (SkillCommand skillCommand : combo) {
            skillCommand.execute();
        }
    }
}

public class Command {

    public static void main(String[] args) {
        UserAction userAction = new UserAction();
        userAction.setSkill(new Poison());
        userAction.setSkill(new Bless());
        userAction.setSkill(new Attack());
        userAction.useCombo();
    }

}
