package com.lessons.lesson04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kirill on 06.03.2016.
 */
public class Foursquare extends Rectangle{

    @Override
    protected void shapeModification(Scanner scanner) throws CommonShapeException {
        ArrayList<Float> temporaryDimensions = super.modifyDimensions(scanner, 1, null);
        temporaryDimensions.add(temporaryDimensions.get(0));
        shapeDimensions.clear();
        shapeDimensions = temporaryDimensions;
        calculateSquare();
    }

    @Override
    public String toString() {
        return "Foursquare{" +
                "shapeDimensions=" + shapeDimensions +
                ", shapeSquare=" + shapeSquare +
                "}";
    }

    public Foursquare() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Foursquare)) return false;

        Foursquare foursquare = (Foursquare) o;

        return Float.compare(foursquare.shapeSquare, shapeSquare) == 0;
    }

}
