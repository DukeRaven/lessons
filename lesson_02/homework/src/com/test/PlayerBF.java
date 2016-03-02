package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * класс представляет собой поле боя человека.
 */
public final class PlayerBF extends Battlefield {

    private static SeaBlock bl;
    private ArrayList<SeaBlock> broken = new ArrayList<>(100);

    /**
     * Определяет КАК поле игрока получает входящие удары: рандомно.
     */

    public void setTarget() {
        Random r = new Random();
        int x, y;

        do {
            x = r.nextInt(10);
            y = r.nextInt(10);
            bl = new SeaBlock(x, y);
            if (!broken.contains(bl)) {
                break;
            }
        } while (!super.fleetIsEmpty());
        broken.add(bl);
        System.out.print("Ходит компьютер:");
        if (super.hitToSea(bl)) {
            setTarget();
        }
        System.out.println("Поле игрока:");
        System.out.println(this);
    }

    @Override
    public String toString() {
        String r = " ";
        for (HorCoords h : HorCoords.values()) {
            r += h.name();
        }
        r += "\n";
        for (int i = 0; i < 10; i++) {
            r += i;
            for (int j = 0; j < 10; j++) {
                r += super.sea()[j][i];
            }
            r += "\n";
        }
        return r;
    }

    @Override
    String winner() {
        return "Компьютер выиграл";
    }
}