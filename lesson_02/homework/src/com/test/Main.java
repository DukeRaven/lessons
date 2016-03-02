package com.test;

public class Main {

    public static void main(String[] args) {
        Battlefield pl = new PlayerBF();
        pl.addRandomShips();
        Battlefield comp = new CompBF();
        Battlefield.attack(comp, pl);
    }
}
