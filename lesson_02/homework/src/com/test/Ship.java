package com.test;

/**
 * Created by Core8 on 26.02.2016.
 */
import java.util.ArrayList;

final class Ship {

    private ArrayList<Module> modules;

    Ship(int x, int y, Rotation r, int q) {

        modules = new ArrayList<>(q);
        int addX = 0;
        int addY = 0;
        for (int i = 0; i < q; i++) {
            modules.add(new Module(x + addX, y + addY));
            addX += r.nextX();
            addY += r.nextY();
            if (modules.get(i).getX() < 0 || modules.get(i).getY() < 0
                    || modules.get(i).getX() > 9
                    || modules.get(i).getY() > 9) {
                throw new IllegalArgumentException("Неверно заданы координаты. "
                        + "Выход за пределы поля");
            }
        }
    }

    int getSize() {
        return modules.size();
    }

    boolean shipIsAlive() {
        //жив ли корабль? (хотя бы 1 модуль)
        for (Module m : modules) {
            if (m.isAlive) {
                return true;
            }
        }
        return false;
    }

    Module getModule(int i) {
        return modules.get(i);
    }

    ArrayList<Module> getModArr() {
        return modules;
    }

    @Override
    public String toString() {
        String r = "";
        for (Module x : modules) {
            r += "\n" + x;
            System.out.print(x);
        }
        return r;
    }
}