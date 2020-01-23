package com.example.skejbydicejava;

public class Player {
    private String name;
    private int sips;
    private int pos;

    public Player(String name, int pos){
        this.name = name;
        this.pos = pos;
        sips = 0;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
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
