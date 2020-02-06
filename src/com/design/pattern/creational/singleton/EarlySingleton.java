package com.design.pattern.creational.singleton;

public class EarlySingleton {
    private EarlySingleton() {}

    private static class EarlySingletonHolder {
        private static final EarlySingleton INSTANCE = new EarlySingleton();
    }

    public static EarlySingleton getInstance() {
        return EarlySingletonHolder.INSTANCE;
    }
}
