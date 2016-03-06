package com.lessons.lesson04;

import java.util.*;

/**
 * Created by Kirill on 06.03.2016.
 */
public class Storage {

    private Scanner scanner = new Scanner(System.in);

    private HashSet<Shape> shapesHashSet = new HashSet<>();
    private ArrayList<Shape> shapesArrayList = new ArrayList<>();

    private void printMenu() {
        System.out.println("МЕНЮ");
        System.out.println("1 - Добавление прямоугольника");
        System.out.println("2 - Добавление треугольника");
        System.out.println("3 - Добавление квадрата");
        System.out.println("4 - Редактирование фигуры");
        System.out.println("5 - Вывод всех фигур из множества");
        System.out.println("6 - Вывод всех фигур с сортировкой из массива");
        System.out.println("7 - Удаление фигуры");
        System.out.println("\n0 - Выход");
        System.out.println("Создано фигур: " + Shape.getTotalCount());
        System.out.println("\n--\nВыберите пункт: ");
    }

    private  void addToCollection(Shape shape) {
        if (!shapesHashSet.add(shape))
            System.out.println("Уже содержится в HashSet");
        shapesArrayList.add(shape);
    }

    private void editCollectionElement(Shape shape, int index) {
        shapesArrayList.set(index, shape);
    }

    private void deleteCollectionElement(int index) {
        shapesHashSet.remove(shapesArrayList.get(index));
        shapesArrayList.remove(index);
    }

    private void printArrayList() {
        System.out.println("ArrayList");
        Collections.sort(shapesArrayList);
        for (int i = 0; i < shapesArrayList.size(); i++)
            System.out.printf("%d - %s\n", i, shapesArrayList.get(i).toString());

    }

    private void printHashSet() {
        System.out.println("HashSet");
        Iterator i = shapesHashSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }

    private void addTriangle () throws CommonShapeException{
        Triangle triangle = new Triangle();
        triangle.enter(scanner);
        addToCollection(triangle);

    }

    private void addRectangle() throws CommonShapeException {
        Rectangle rectangle = new Rectangle();
        rectangle.enter(scanner);
        addToCollection(rectangle);
    }

    private void addFoursquare() throws CommonShapeException {
        Foursquare foursquare = new Foursquare();
        foursquare.enter(scanner);
        addToCollection(foursquare);

    }

    private void deleteShape() {
        System.out.print("Введите индекс элемента: ");
        int index = scanner.nextInt();
        deleteCollectionElement(index);
    }

    private void editShape() throws CommonShapeException {
        System.out.print("Введите индекс элемента: ");
        int index = scanner.nextInt();
        Shape shape = shapesArrayList.get(index);
        shape.edit(scanner);
        editCollectionElement(shape, index);

    }

    public void start() {
        int i;

        while (true) {
            printMenu();
            i = scanner.nextInt();
            try {
                switch (i){
                    case 1:
                        addRectangle();
                        break;
                    case 2:
                        addTriangle();
                        break;
                    case 3:
                        addFoursquare();
                        break;
                    case 4:
                        editShape();
                        break;
                    case 5:
                        printHashSet();
                        break;
                    case 6:
                        printArrayList();
                        break;
                    case 7:
                        deleteShape();
                        break;
                    case 0:
                        System.out.println("Выход");
                        return;
                    default:
                        System.out.println("Неверный пункт меню, повторите ввод");
                        break;
                }
            } catch (CommonShapeException e) {
                System.out.println("Произошла ошибка: " + e.toString());

            }
        }
    }
}
