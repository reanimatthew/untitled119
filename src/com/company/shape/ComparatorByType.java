package com.company.shape;

import java.util.Comparator;

public class ComparatorByType implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
