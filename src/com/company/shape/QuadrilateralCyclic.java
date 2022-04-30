package com.company.shape;

import java.util.Locale;

class QuadrilateralCyclic extends Quadrilateral implements Incircle {

    QuadrilateralCyclic(double firstSide, double secondSide, double thirdSide, double fourthSide, float firstAngle, float secondAngle) {
        super(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }

    @Override
    public double getIncircle() {
        return getSquare() * 2 / getPerimeter();
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник, со сторонами: %.1f, %.1f, %.1f, %.1f, в который можно вписать окружность.\n" +
                "Периметр: %.1f, площадь: %.1f.\n" +
                "Радиус вписанной окружности: %.1f.",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare(), getIncircle());
    }
}
