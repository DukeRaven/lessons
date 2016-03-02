package com.lessons.n03;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by Kirill on 01.03.2016.
 */
public class Storage {

    private static Scanner sc = new Scanner(System.in);

    private static HashSet<Participant> hs = new HashSet<>();
    private static ArrayList<Participant> al = new ArrayList<>();

    private static void printMenu() {
        System.out.println("МЕНЮ");
        System.out.println("1 - Добавление студента");
        System.out.println("2 - Добавление преподавателя");
        System.out.println("3 - Вывод всех участников");
        System.out.println("4 - Вывод всех участников с сортировкой");
        System.out.println("5 - Редактирование участника");
        System.out.println("\n0 - Выход");
        System.out.println("\n--\nВыберите пункт: ");
    }

    private static void addToCollection(Participant p) {
        if (!hs.add(p))
            System.out.println("Уже содержится в HashSet");
        al.add(p);
    }

    private static void editCollectionElement(Participant p, int index) {
        hs.remove(p);
        hs.add(p);

        al.set(index, p);
    }

    private static void printCollections() {
        Participant p;
        Iterator i = al.iterator();
        System.out.println("ArrayList");
        while (i.hasNext()) {
            p = (Participant) i.next();
            System.out.println(al.indexOf(p) + " - " + p.toString());
        }

        System.out.println("HashSet");
        i = hs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().toString());
        }


    }

    public static void start() {
        int i, j;
        Participant p;

        while (true) {
            printMenu();
            i = sc.nextInt();
            try {
                switch (i){
                    case 1:
                        p = new Student();
                        p.add(sc);
                        addToCollection(p);
                        break;
                    case 2:
                        p = new Teacher();
                        p.add(sc);
                        addToCollection(p);
                        break;
                    case 3:
                        System.out.println("Список участников");
                        printCollections();
                        break;
                    case 4:
                        System.out.println("Отсортированный список участников");
                        Collections.sort(al);
                        printCollections();
                        break;
                    case 5:
                        try {
                            System.out.println("Введите порядковый номер участника: ");
                            j = sc.nextInt();
                            p = al.get(j);
                            p.edit(sc);
                            editCollectionElement(p, j);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Неверный порядковый номер.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Неверный пункт меню, повторите ввод");
                        break;
                }
            } catch (MyException e) {
                System.out.println("Произошла ошибка: " + e.toString());

            }
        }
    }
}
