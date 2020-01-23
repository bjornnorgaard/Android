package com.example.skejbydicejava;

public class Player {
    private String name;
    private int sips;
    private int pos;
    private int token;

    public Player(String name, int pos,int token){
        this.name = name;
        this.pos = pos;
        this.token = token;
        sips = 0;
    }

    public int getToken() {
        return token;
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
