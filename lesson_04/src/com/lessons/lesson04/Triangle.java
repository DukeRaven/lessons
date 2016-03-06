package com.lessons.lesson04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kirill on 06.03.2016.
 */
public class Triangle extends Shape {

    @Override
    protected void shapeModification(Scanner scanner) throws CommonShapeException {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Введите 1й катет:");
        messages.add("Введите 2й катет:");
        messages.add("Введите гипотенузу:");

        ArrayList<Float> temporaryDimensions = super.modifyDimensions(scanner, 3, messages);
        shapeDimensions.clear();
        shapeDimensions = temporaryDimensions;
        calculateSquare();
    }

    @Override
    protected void enter(Scanner scanner) throws CommonShapeException {
        shapeModification(scanner);
    }

    @Override
    protected void edit(Scanner scanner) throws CommonShapeException {
        shapeModification(scanner);
    }

    @Override
    public void calculateSquare() {
        shapeSquare = (shapeDimensions.get(0) * shapeDimensions.get(1)) / 2;
    }

    @Override
    public String toString() {
        return "Triangle{"  +
                super.toString() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        return Float.compare(triangle.shapeSquare, shapeSquare) == 0;

    }
}
