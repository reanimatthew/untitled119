package com.company.shape;

import java.util.Locale;

public class Quadrilateral implements Perimeter, Square {
    double firstSide;
    double secondSide;
    double thirdSide;
    double fourthSide;
    float firstAngle;
    float secondAngle;

    Quadrilateral(double firstSide, double secondSide, double thirdSide, double fourthSide, float firstAngle, float secondAngle) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.fourthSide = fourthSide;
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
    }


    @Override
    public double getPerimeter() {
        return firstSide + secondSide + thirdSide + fourthSide;
    }

    @Override
    public double getSquare() {
        return Math.sqrt(
                (getPerimeter() / 2 - firstSide) *
                        (getPerimeter() / 2 - secondSide) *
                        (getPerimeter() / 2 - thirdSide) *
                        (getPerimeter() / 2 - fourthSide)
                        -
                        firstSide * secondSide * thirdSide * fourthSide *
                                Math.pow(
                                        Math.cos((double) (firstAngle + secondAngle) / 2.),
                                        2)
        );
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник со сторонами: %.1f, %.1f, %.1f, %.1f, периметром %.1f, и площадью %.1f.",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare());
    }
}
