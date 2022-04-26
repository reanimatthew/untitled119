package com.company.shape;

import java.util.Locale;

public class Circle implements Square, Perimeter {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public double getSquare() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "круг с радиусом %.1f, периметром %.1f и площадью %.1f.", radius, getPerimeter(), getSquare());
    }
}
