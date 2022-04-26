package com.company.shape;

import java.util.Locale;

public class TriangleE extends Triangle implements SameSidesSameAngles {

    TriangleE(double firstSide) {
        super(firstSide, firstSide, firstSide);
    }

    @Override
    public double getAngle() {
        return 60.;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "равносторонний треугольник со сторонами равными: %.1f, периметром: %.1f, площадью: %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f.\n" +
                        "Это правильный многоугольник, его углы равны %.0f°.",
                firstSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle(), getAngle());
    }
}
