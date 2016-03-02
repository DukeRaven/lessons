package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */
enum HorCoords {

    A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), L(9);
    private int coord;

    HorCoords(int i) {
        coord = i;
    }

    int getCoord() {
        return coord;
    }
}