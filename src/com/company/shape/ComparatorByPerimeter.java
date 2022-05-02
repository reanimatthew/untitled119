package com.company.shape;

import java.util.Comparator;

public class ComparatorByPerimeter implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getPerimeter().compareTo(o2.getPerimeter());
    }
}
