package com.company.shape;

import java.util.Locale;

class QuadrilateralSquare extends Quadrilateral implements SameSidesSameAngles {

    QuadrilateralSquare(double firstSide) {
        super(firstSide, firstSide, firstSide, firstSide, 90, 90);
    }

    @Override
    public double getSquare() {
        return firstSide * firstSide;
    }

    @Override
    public double getCircumcircle() {
        return Math.sqrt(2) * firstSide / 2;
    }

    @Override
    public double getIncircle() {
        return firstSide / 2;
    }

    @Override
    public double getAngle() {
        return firstAngle;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "квадрат со стороной: %.1f. Периметр: %.1f, площадь: %.1f.\n" +
                        "Радиус вписанной окружности: %.1f, а радиус описанной окружности: %.1f.\n" +
                        "Это правильный многогранник, его углы равны %.0f°",
                firstSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle(), getAngle());
    }
}
