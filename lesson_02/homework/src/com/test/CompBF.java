package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * реализует поле боя компьютера.
 */
public final class CompBF extends Battlefield {

    Scanner sc = new Scanner(System.in);
    /**
     * заполняет рандомными кораблями всё поле.
     */
    public CompBF() {
        super.addRandomShips();
    }

    /**
     * реализует ВХОДЯЩИЕ удары. Поле комптьютера -> по нему бьёт человек. метод
     * требует ввода.
     */
    @Override
    public void setTarget() {
        String in;
        String x = "";
        int y = -1;
        ArrayList<String> hor = new ArrayList<>();
        for (HorCoords h : HorCoords.values()) {
            hor.add(h.toString());
        }
        System.out.println("Поле компьютера:");
        System.out.println(this);
        do {
            System.out.print("Введите координаты (формат 'X Y'):");
            if (sc.hasNext("^[a-lA-L]{1}\\s\\d{1}$")) {
                in = sc.nextLine();
                x = String.valueOf(in.charAt(0)).toUpperCase();
                System.out.print(in.charAt(2));
                y = Character.getNumericValue(in.charAt(2));
            } else {
                System.out.println("Неверный формат или данные, повторите ввод.");
                continue;
            }
        } while (!hor.contains(x) || y < 0 || y > 9);
        if (super.hitToSea(new SeaBlock(HorCoords.valueOf(x).getCoord(), y))) {
            setTarget();
        }
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
                if (sea()[j][i].isAlive) {
                    r += " ";

                } else {
                    r += sea()[j][i];
                }
            }
            r += "\n";
        }
        return r;
    }

    @Override
    String winner() {
        return "ЧЕЛОВЕК ВЫИГРАЛ";
    }
}
