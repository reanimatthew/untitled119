package com.company.shape;

import java.util.Comparator;

public class ComparatorForFigures {
    private static final Comparator<Shape> bySquare = Comparator.comparing(Shape::getSquare);

    private static final Comparator<Shape> byPerimeter = Comparator.comparing(Shape::getPerimeter);

    private static final Comparator<Shape> byType = Comparator.comparing(Shape::getType);

    private static final Comparator<Shape> byCorners = Comparator.comparing(Shape::getNumberOfCorners);

    public static Comparator<Shape> GetFiguresComparator() {
        return byCorners.thenComparing(byType).thenComparing(byPerimeter).thenComparing(bySquare);
    }
}
