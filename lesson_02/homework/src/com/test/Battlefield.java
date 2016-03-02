package com.test;

import java.util.*;

/**
 * Created by Core8 on 26.02.2016.
 */
public abstract class Battlefield {

    private ArrayList<Ship> fleet;
    private HashSet<Ban> bans;
    private Ship ship1;
    private SeaBlock sea[][];

    /**
     * создаёт массив 10 на 10 с чистыми квадратами SeaBlock и коллекции для
     * хранения флота и запретных зон.
     */
    Battlefield() {
        fleet = new ArrayList<>(10);
        bans = new HashSet<>();
        sea = new SeaBlock[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sea[i][j] = new SeaBlock(i, j);
            }
        }
    }

    /**
     * Метод для начала игры между двумя объектами интерфейса Battlefield.
     * Выполняется пока не будут уничтожены все корабли любого из флотов.
     *
     * @param f1 Поле боя 1.
     * @param f2 Поле боя 2.
     */
    public static void attack(Battlefield f1, Battlefield f2) {
        while (true) {
            f1.setTarget();
            f2.setTarget();
            if (f1.fleetIsEmpty()) {
                f1.winner();
            }
            if (f2.fleetIsEmpty()) {
                f2.winner();
            }
        }
    }

    /**
     * Здесь должно определяется КАК поле боя получает входящие удары по СЕБЕ.
     */
    public abstract void setTarget();

    /**
     * Метод наносящий удар по полю боя. При убийстве корабля, удалить его из
     * флота.
     *
     * @param b блок-цель.
     * @return разрешение нанести ещё один удар (если ранил/убил корабль).
     */
    final boolean hitToSea(SeaBlock b) {

        try {
            sea[b.getX()][b.getY()].hit();
            if (!shipContBlock(sea[b.getX()][b.getY()]).shipIsAlive()) {
                System.out.println("убит");
                fleet.remove(shipContBlock(b));
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Метод возвращает корабль, который содержит указанный блок-параметр.
     *
     * @param b задать блок
     * @return выдаёт корабль который содержит блок-параметр
     * @exception если совершен промах, то бросает исключение.
     */
    private Ship shipContBlock(SeaBlock b) {
        for (Ship s : fleet) {
            if (s.getModArr().contains(b)) {
                return s;
            }
        }
        throw new IllegalArgumentException("мимо");
    }

    /**
     * добавляет рандомные корабли.
     */
    public final void addRandomShips() {
        Random r = new Random();
        Rotation[] rot = Rotation.values();
        HorCoords[] hor = HorCoords.values();
        for (int q = 4; q >= 1; q--) { //q-количество палуб
            for (int i = 5 - q, s = 0; s < i; s++) {
                if (!(addShip(hor[r.nextInt(10)], r.nextInt(10),
                        rot[r.nextInt(2)], q))) {
                    s--;
                }
            }
        }
    }

    /**
     * Общий метод, проверяющий заданные координаты на предмет близкого
     * расположения к другому кораблю, добавляющий корабль на поле боя(массив) и
     * во флот(коллекция).
     *
     * @param x координата по горизонтали.
     * @param y координата по вертикали.
     * @param r в какую сторону поворот.
     * @param q длина корабля.
     * @return true если корабль успешно добавлен. иначе возвращает false.
     */
    private boolean addShip(HorCoords x, int y, Rotation r, int q) {
        try {
            ship1 = new Ship(x.getCoord(), y, r, q);
            banCheck(ship1);
            fleet.add(ship1);
            addShipToSea(ship1);
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * вспомогательный метод для добавления модулей корабля на поле боя.
     */
    private void addShipToSea(Ship a) {
        for (Module m : a.getModArr()) {
            sea[m.getX()][m.getY()] = m;
        }
    }

    /**
     * вспомогательный метод для проверки корабля на предмет близкого нахождения
     * к другому кораблю.
     *
     * @param a проверяемый корабль.
     * @exception если корабль близко к другому то бросает исключение.
     */
    private void banCheck(Ship a) {
        for (int i = 0; i < a.getSize(); i++) {
            if (bans.contains(a.getModule(i))) {
                throw new IllegalArgumentException("корабль близко к другому");
            }
        }
        for (int i = 0; i < a.getSize(); i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    bans.add(new Ban(ship1.getModule(i).getX() - 1 + k,
                            ship1.getModule(i).getY() - 1 + j));
                }
            }
        }
    }

    /**
     *
     * (возможно переставить местами x и y, i и j.)
     *
     * @return возвращает строку которая представляет собой поле боя.
     */
    @Override
    public abstract String toString();

    abstract String winner();

    boolean fleetIsEmpty() {
        return fleet.isEmpty();
    }

    SeaBlock[][] sea() {
        return sea;
    }
}
