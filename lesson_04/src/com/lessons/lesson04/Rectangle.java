package com.lessons.lesson04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kirill on 06.03.2016.
 */
public class Rectangle extends Shape {

    private void checkSides(ArrayList<Float> temporaryDimensions) throws SameSidesExcpetion {
        if (temporaryDimensions.get(0) == temporaryDimensions.get(1))
            throw new SameSidesExcpetion("Строны прямоугольника должны отличаться по длине.");
    }

    @Override
    protected void shapeModification(Scanner scanner) throws CommonShapeException {
        ArrayList<Float> temporaryDimensions = super.modifyDimensions(scanner, 2, null);
        checkSides(temporaryDimensions);
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
        shapeSquare = shapeDimensions.get(0) * shapeDimensions.get(1);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
               super.toString() +
               "}";
    }

    public Rectangle() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;

        return Float.compare(rectangle.shapeSquare, shapeSquare) == 0;
    }
}
