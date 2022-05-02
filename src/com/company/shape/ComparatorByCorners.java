package com.company.shape;

import java.util.Comparator;

public class ComparatorByCorners implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getNumberOfCorners().compareTo(o2.getNumberOfCorners());
    }
}
