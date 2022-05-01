package com.company.shape;

import java.math.BigDecimal;
import java.util.Locale;

public class TriangleRight extends Triangle {

    TriangleRight(BigDecimal firstCathetus, BigDecimal secondCathetus) {
        super(firstCathetus, secondCathetus, new BigDecimal("90"));
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "прямоугольный треугольник со сторонами: %.1f, %.1f, %.1f, периметром: %.1f, площадью: %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f.",
                firstSide, secondSide, thirdSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
