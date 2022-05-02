package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

class QuadrilateralBicentric extends Quadrilateral implements Incircle, Circumcircle {

    QuadrilateralBicentric(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide, BigDecimal fourthSide, BigDecimal firstAngle, BigDecimal secondAngle) {
        super(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }

    @Override
    public BigDecimal getCircumcircle() {
        return BigDecimalMath.sqrt(
                firstSide.multiply(secondSide).add(thirdSide.multiply(fourthSide)).multiply(
                        fourthSide.multiply(thirdSide).add(secondSide.multiply(fourthSide))).multiply(
                        fourthSide.multiply(fourthSide).add(secondSide.multiply(thirdSide))).divide(
                        getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(firstSide), 50, RoundingMode.HALF_UP).divide(
                        getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(secondSide), 50, RoundingMode.HALF_UP).divide(
                        getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(thirdSide), 50, RoundingMode.HALF_UP).divide(
                        getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(fourthSide), 50, RoundingMode.HALF_UP),
                MATH_CONTEXT_50
        ).multiply(new BigDecimal("0.25"));
    }

    @Override
    public BigDecimal getIncircle() {
        return getSquare().multiply(BIG_DECIMAL_2).divide(getPerimeter(), 50, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник, со сторонами: %.1f, %.1f, %.1f, %.1f, в который можно вписать окружность и вокруг которого можно описать окружность. " +
                        "Периметр: %.1f, площадь: %.1f. Радиус вписанной окружности: %.1f, а радиус описанной окружности: %.1f.\n",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
