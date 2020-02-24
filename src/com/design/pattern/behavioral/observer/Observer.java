package com.design.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

abstract class MapSubject {
    private String mapId;

    public MapSubject(String mapId) {
        this.mapId = mapId;
    }

    private List<MapObserver> observers = new ArrayList<>();

    public void addObserver(MapObserver mapObserver) {
        observers.add(mapObserver);
    }

    public void notifyChange() {
        for (MapObserver mapObserver : observers) {
            mapObserver.update(mapId);
        }
    };
}

class MapDetail extends MapSubject {

    public MapDetail(String mapId) {
        super(mapId);
    }

    public void openMap() {
        notifyChange();
    }

}

abstract class MapObserver {
    abstract void update(String mapId);
}

class UserMapObserver extends MapObserver {

    private User user = null;

    public UserMapObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String mapId) {
        user.joinMap(mapId);
    }
}

class User {

    String name = null;
    public User(String name) {
        this.name = name;
    }

    public void joinMap(String map) {
        System.out.println(name + " get a notify from : " + map + " map");
    }
}

public class Observer {

    public static void main(String[] args) {
        User userA = new User("UserA");
        User userB = new User("UserB");
        UserMapObserver userMapObserver = new UserMapObserver(userA);
        UserMapObserver userMapObserverB = new UserMapObserver(userB);
        MapDetail map = new MapDetail("Jungle");
        map.addObserver(userMapObserver);
        map.addObserver(userMapObserverB);
        map.notifyChange();
    }
}
