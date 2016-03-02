package com.lessons.n03;

import java.util.Scanner;

/**
 * Created by Kirill on 29.02.2016.
 */
public class Student extends Participant {
    private float averageScore;

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    protected void modification(Scanner scanner) throws MyException {
        float i;
        super.modification(scanner);
        System.out.println("Введите среднюю оценку: ");
        if (scanner.hasNextFloat()) {
            i = scanner.nextFloat();
            if (i < 0)
                throw new InvalidAverageScoreException("Средняя оценка должна быть больше 0");
            averageScore = i;

        }
    }
    @Override
    public void add(Scanner scanner) throws MyException {
        System.out.println("Ввод данных студента");
        modification(scanner);
    }

    @Override
    public void edit(Scanner scanner) throws MyException{
        System.out.println("Изменение данных студента");
        modification(scanner);
    }

    @Override
    public String toString() {
        return "Student{" +
                " age=" + getAge() +
                " name=" + getName() +
                " averageScore=" + averageScore +
                " }";
    }


}
