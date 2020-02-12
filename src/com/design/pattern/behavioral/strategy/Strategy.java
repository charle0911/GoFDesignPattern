package com.design.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

interface Skill {
    void doAction();
}

class FireSkill implements Skill {
    @Override
    public void doAction() {
        System.out.println("Use fire to attack");
    }
}

class HealSkill implements Skill {
    @Override
    public void doAction() {
        System.out.println("Heal myself");
    }
}

class SkillService {
    private Map<String, Skill> skillMap = new HashMap<>();

    public SkillService() {
        skillMap.put("FireAttack", new FireSkill());
        skillMap.put("Heal", new HealSkill());
    }

    public void doAction(String skillType) {
        Skill skill = skillMap.get(skillType);
        skill.doAction();
    }
}

public class Strategy {

    public static void main(String[] args) {
        SkillService skillService = new SkillService();
        skillService.doAction("FireAttack");
        skillService.doAction("Heal");
    }

}
