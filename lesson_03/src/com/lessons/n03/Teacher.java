package com.lessons.n03;

import java.util.Scanner;

/**
 * Created by Kirill on 01.03.2016.
 */
public class Teacher extends Participant {
    private int yearNumber;

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    private static int instanceCounter = 0;

    @Override
    public void add(Scanner scanner) throws MyException {
        System.out.println("Ввод данных преподавателя");
        modification(scanner);
    }

    @Override
    public void edit(Scanner scanner) throws MyException {
        System.out.println("Ввод данных преподавателя");
        modification(scanner);

    }

    @Override
    protected void modification(Scanner scanner) throws MyException {
        int i;
        super.modification(scanner);
        System.out.println("Введите количество лет стажа: ");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            if (i <= 0)
                throw new InvalidTeacherYearsException("Количество лет стажа должно быть больше 0");
            yearNumber = i;
        }

    }

    @Override
    public String toString() {
        return "Teacher{" +
                " age=" + getAge() +
                " name=" + getName() +
                " yearNumber=" + yearNumber +
                " instanceCounter=" + instanceCounter +
                " }";
    }

    public Teacher() {
        instanceCounter++;
    }
}
