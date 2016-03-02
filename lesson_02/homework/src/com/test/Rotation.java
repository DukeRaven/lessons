package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */
enum Rotation {

    Up, Right;

    int nextX() {
        if (this.equals(Right)) {
            return 1;
        } else {
            return 0;
        }
    }

    int nextY() {
        if (this.equals(Up)) {
            return -1;
        } else {
            return 0;
        }
    }
}