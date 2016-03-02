package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */
class Module extends SeaBlock {

    Module(int x, int y) {
        super(x, y);
        live = "\u25A1";
        dead = "X";
        content = live;
    }

    @Override
    boolean hit() {
        if (isAlive) {
            isAlive = false;
            content = dead;
            return true; // ходить можно ещё раз? ДА т.к. произошло попадание по
            //модулю корабля
        } else {
            throw new IllegalArgumentException("ячейка уже подбита");
        }
    }
}
