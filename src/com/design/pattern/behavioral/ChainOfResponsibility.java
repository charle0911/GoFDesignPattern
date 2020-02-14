package com.design.pattern.behavioral;

abstract class Handler {
    Handler nextHandler = null;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void execute() {
        action();
        if (nextHandler != null) {
            nextHandler.execute();
        }
    }

    abstract void action();
}

class ImproveAttackHandler extends Handler {

    public ImproveAttackHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void action() {
        System.out.println("Improve attack ability");
    }
}

class HitsRateHandler extends Handler {

    public HitsRateHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void action() {
        System.out.println("Improve hits rate ability");
    }
}

class SpecialAbilityHandler extends Handler {

    public SpecialAbilityHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void action() {
        System.out.println("Add special ability");
    }
}

class FinishHandler extends Handler {

    public FinishHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void action() {
        System.out.println("Take out weapon from smithy");
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        System.out.println("Start to make a weapon");
        Handler handler = new ImproveAttackHandler(
                new SpecialAbilityHandler(
                        new HitsRateHandler(
                                new FinishHandler(null)
                        )
                )
        );
        handler.execute();
    }
}
