package com.company.shape;

import java.util.Comparator;

public class ComparatorBySquare implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getSquare().compareTo(o2.getSquare());
    }
}
