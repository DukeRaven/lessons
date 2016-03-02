package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */
class SeaBlock extends Block {

    String live = " ";
    String dead = "\u2022";
    boolean isAlive = true;
    String content = live;

    SeaBlock(int x, int y) {
        super(x, y);
    }

    boolean isAlive() {
        return isAlive;
    }

    boolean hit() {
        if (isAlive) {
            isAlive = false;
            content = dead;
            return false; // возвожно ли ходить ещё раз??
            // тут нельзя т.к. попадание по морю в любом случае промах
        } else {
            throw new IllegalArgumentException("ячейка уже подбита");
        }
    }

    @Override
    public String toString() {
        return content;
    }
}
