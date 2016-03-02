package com.lessons.n03;

import java.util.Scanner;

/**
 * Created by Kirill on 29.02.2016.
 */
public abstract class Participant implements Comparable {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    protected void modification(Scanner scanner) throws MyException {
        System.out.println("Введите возраст: ");
            if (scanner.hasNextInt()) {
                this.setAge(scanner.nextInt());
            }
            System.out.println("Введите имя: ");
            this.setName(scanner.next());
    }

    public void setAge(int age) throws MyException {
        if (age < 18)
            throw new InvalidAgeException("Возраст не может быть меньше 18 лет");
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public abstract void add(Scanner scanner) throws MyException ;

    public abstract void edit(Scanner scanner) throws MyException;


    @Override
    public int compareTo(Object o) {
        Participant entry = (Participant) o;
        if (this.age > entry.getAge())
            return 1;
        if (this.age < entry.getAge())
            return -1;
        else
            return 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Participant)
            return ((Participant) obj).getName().equals(this.name);
        else
            return false;
    }

    public abstract String toString();

}
