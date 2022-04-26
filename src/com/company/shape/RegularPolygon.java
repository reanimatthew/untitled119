package com.company.shape;

import java.util.Locale;

public class RegularPolygon implements SameSidesSameAngles {
    double side;
    int numberOfSides;

    public RegularPolygon(double side, int numberOfSides) {
        this.side = side;
        this.numberOfSides = numberOfSides;
    }

    @Override
    public double getCircumcircle() {
        return getIncircle() / Math.cos(Math.PI / numberOfSides);
    }

    @Override
    public double getIncircle() {
        return getSquare() * 2 / getPerimeter();
    }

    @Override
    public double getPerimeter() {
        return side * numberOfSides;
    }

    @Override
    public double getSquare() {
        return Math.PI / 4 * Math.pow(side, 2) * 1 / Math.tan(Math.PI / numberOfSides);
    }

    @Override
    public double getAngle() {
        return 180. * (numberOfSides - 2) / numberOfSides;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "многоугольник с %d сторонами, равными %.1f, периметром: %.1f и площадью %.1f.\n" +
                "Радиус вписанной окружности: %.1f, радиус описанной окружности: %.1f.\n" +
                        "Это правильный многоугольник с углами, равными %.0f°.",
                numberOfSides, side, getPerimeter(), getSquare(), getIncircle(), getCircumcircle(), getAngle());
    }
}
