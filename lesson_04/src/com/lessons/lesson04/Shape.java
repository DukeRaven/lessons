package com.lessons.lesson04;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kirill on 06.03.2016.
 */
public abstract class Shape implements Comparable<Shape>{

    protected ArrayList<Float> shapeDimensions = new ArrayList<>();
    protected static int totalCount = 0;
    protected float shapeSquare = 0;

    protected ArrayList<Float> modifyDimensions(Scanner scanner, int sidesNumber, ArrayList<String> messages) throws CommonShapeException {
        ArrayList<Float> temporaryDimensions = new ArrayList<>();
        for (int i = 1; i<=sidesNumber; i++) {
            if (messages == null)
                System.out.printf("Введите %d сторону: ", i);
            else
                System.out.println(messages.get(i - 1));
            temporaryDimensions.add(scanner.nextFloat());
        }
        return temporaryDimensions;
    }

    protected abstract void shapeModification(Scanner scanner) throws CommonShapeException;

    protected abstract void enter(Scanner scanner) throws CommonShapeException;

    protected abstract void edit(Scanner scanner) throws CommonShapeException;

    public abstract void calculateSquare();

    @Override
    public int compareTo(Shape o) {
        return Math.round(this.shapeSquare - o.shapeSquare);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;

        Shape shape = (Shape) o;

        return Float.compare(shape.shapeSquare, shapeSquare) == 0;

    }

    @Override
    public int hashCode() {
        return (shapeSquare != +0.0f ? Float.floatToIntBits(shapeSquare) : 0);
    }

    @Override
    public String toString() {
        return "shapeDimensions=" + shapeDimensions +
               ", shapeSquare=" + shapeSquare;
    }

    public Shape() {
        totalCount++;
    }

    public static int getTotalCount() {
        return totalCount;
    }
}
