package com.company.shape;

import java.util.Locale;

public class TriangleR extends Triangle {

    //TODO переименовать нормально классы

    TriangleR(double firstCathetus, double secondCathetus) {
        super(firstCathetus, secondCathetus, 90);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "прямоугольный треугольник со сторонами: %.1f, %.1f, %.1f, периметром: %.1f, площадью: %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f.",
                firstSide, secondSide, thirdSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
