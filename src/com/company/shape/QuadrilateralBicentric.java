package com.company.shape;

import java.util.Locale;

class QuadrilateralBicentric extends Quadrilateral implements Incircle, Circumcircle {

    QuadrilateralBicentric(double firstSide, double secondSide, double thirdSide, double fourthSide, float firstAngle, float secondAngle) {
        super(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }

    @Override
    public double getCircumcircle() {
        return 0.25 * Math.sqrt(
                (firstSide * secondSide + thirdSide * fourthSide) *
                        (firstSide * thirdSide + secondSide * fourthSide) *
                        (firstSide * fourthSide + secondSide * thirdSide) /
                        (getPerimeter() / 2 - firstSide) /
                        (getPerimeter() / 2 - secondSide) /
                        (getPerimeter() / 2 - thirdSide) /
                        (getPerimeter() / 2 - fourthSide)
        );
    }

    @Override
    public double getIncircle() {
        return getSquare() * 2 / getPerimeter();
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник, со сторонами: %.1f, %.1f, %.1f, %.1f, в который можно вписать окружность и вокруг которого можно описать окружность. " +
                        "Периметр: %.1f, площадь: %.1f. Радиус вписанной окружности: %.1f, а радиус описанной окружности: %.1f.",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
