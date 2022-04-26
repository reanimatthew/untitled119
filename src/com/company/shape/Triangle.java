package com.company.shape;

import java.util.Locale;

public class Triangle implements Perimeter, Square, Incircle, Circumcircle {
    double firstSide;
    double secondSide;
    double thirdSide;

    Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    Triangle(double firstSide, double secondSide, float angle) {    // angle between sides
        this(firstSide,
                secondSide,
                Math.sqrt(firstSide * firstSide + secondSide * secondSide + firstSide * secondSide * Math.cos(Math.toRadians(angle))));
    }

    Triangle(double firstSide, float secondAngle, float thirdAngle) {   // adjacent corners
        this(firstSide,
                firstSide * Math.sin(secondAngle) / Math.sin(Math.toRadians(180 - secondAngle - thirdAngle)),
                firstSide * Math.sin(thirdAngle) / Math.sin(Math.toRadians(180 - secondAngle - thirdAngle)));
    }


    @Override
    public double getCircumcircle() {
        return firstSide * secondSide * thirdSide / getSquare() / 4;
    }

    @Override
    public double getIncircle() {
        return getSquare() / getPerimeter() * 2;
    }

    @Override
    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double getSquare() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "треугольник со сторонами: %.1f, %.1f, %.1f, периметром %.1f, площадью %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f",
                firstSide, secondSide, thirdSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
