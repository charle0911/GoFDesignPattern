package com.design.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

interface User {
    void receive(String txt);
    void enter(Room room);
    void broadcast(String txt);
    void privateMessage(String txt, User u);
    long getId();
}

class GameUser implements User {
    static class Channel {
        String ip;

        public Channel(String ip) {
            this.ip = ip;
        }

        public void send(String content) {
            // Use http
            System.out.println("Send websocket packet to ip :" + ip + ", content :" + content);
        }
    }

    Channel channel;
    Room room;
    long id;

    GameUser (String ip, long id) {
        this.channel = new Channel(ip);
        this.id = id;
    }

    @Override
    public void receive(String txt) {
        System.out.println("User " + id + " receive message. " + txt);
        channel.send(txt);
    }

    @Override
    public void enter(Room room) {
        this.room = room;
    }

    @Override
    public void broadcast(String txt) {
        room.broadcast(txt, this);
    }

    @Override
    public void privateMessage(String txt, User u) {
        System.out.println("User " + id + " send message to " + u.getId());
        room.privateMessage(txt, this, u);
    }

    @Override
    public long getId() {
        return id;
    }

}

interface Room {
    void join(User user);

    void broadcast(String txt, User source);

    void privateMessage(String txt, User source, User target);
}

public class HeroGameRoom implements Room {

    List<User> users = new ArrayList<>();

    @Override
    public void join(User user) {
        users.add(user);
        user.enter(this);
    }

    @Override
    public void broadcast(String txt, User source) {
        System.out.println("User " + source.getId() + " send broadcast.");
        users.forEach(x -> x.receive(txt));
    }

    @Override
    public void privateMessage(String txt, User source, User target) {
        users.forEach(x -> {
            if (x.getId() == target.getId()) {
                x.receive(txt);
            }
        });
    }

    public static void main(String[] args) {
        Room room = new HeroGameRoom();
        User u1 = new GameUser("123.123.123.123", 1234);
        User u2 = new GameUser("123.123.123.124", 1235);
        User u3 = new GameUser("123.123.123.125", 1236);
        room.join(u1);
        room.join(u2);
        room.join(u3);

        u1.broadcast("Hi ");
        u1.privateMessage("Hi u2", u2);
    }
}
