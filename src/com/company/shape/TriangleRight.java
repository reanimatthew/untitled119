package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Locale;

public class TriangleRight extends Triangle {

    TriangleRight(BigDecimal firstCathetus, BigDecimal secondCathetus) {
        super(firstCathetus,
                secondCathetus,
                BigDecimalMath.sqrt(firstCathetus.pow(2).add(secondCathetus.pow(2)), MATH_CONTEXT_50));
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "прямоугольный треугольник со сторонами: %.1f, %.1f, %.1f, периметром: %.1f, площадью: %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f.\n",
                firstSide, secondSide, thirdSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
