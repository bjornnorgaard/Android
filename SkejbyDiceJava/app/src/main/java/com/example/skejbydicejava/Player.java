package com.example.skejbydicejava;

public class Player {
    private String name;
    private int sips;

    public Player(String name){
        this.name = name;
        sips = 0;
    }

    public String getName() {
        return name;
    }

    public int getSips() {
        return sips;
    }

    public void setSips(int sips) {
        this.sips = sips;
    }

    public void addSips(int num) {
        sips += num;
    }
}
