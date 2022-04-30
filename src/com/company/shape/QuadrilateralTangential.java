package com.company.shape;

import java.util.Locale;

class QuadrilateralTangential extends Quadrilateral implements Circumcircle {

    QuadrilateralTangential(double firstSide, double secondSide, double thirdSide, double fourthSide, float firstAngle, float secondAngle) {
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
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник, со сторонами: %.1f, %.1f, %.1f, %.1f, вокруг которого можно описать окружность.\n" +
                        "Периметр: %.1f, , площадь: %.1f. Радиус описанной окружности: %.1f.",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare(), getCircumcircle());
    }
}
