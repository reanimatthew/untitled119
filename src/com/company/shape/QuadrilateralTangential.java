package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

class QuadrilateralTangential extends Quadrilateral implements Circumcircle {

    QuadrilateralTangential(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide, BigDecimal fourthSide, BigDecimal firstAngle, BigDecimal secondAngle) {
        super(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }

    @Override
    public BigDecimal getCircumcircle() {
        return BigDecimalMath.sqrt(
                firstSide.multiply(secondSide).add(thirdSide.multiply(fourthSide)).multiply(
                        fourthSide.multiply(thirdSide).add(secondSide.multiply(fourthSide))).multiply(
                        fourthSide.multiply(fourthSide).add(secondSide.multiply(thirdSide))).divide(
                        getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(firstSide), 50, RoundingMode.HALF_UP).divide(
                        getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(secondSide), 50, RoundingMode.HALF_UP).divide(
                        getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(thirdSide), 50, RoundingMode.HALF_UP).divide(
                        getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(fourthSide), 50, RoundingMode.HALF_UP),
                new MathContext(50)
        ).multiply(new BigDecimal("0.25"));
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник, со сторонами: %.1f, %.1f, %.1f, %.1f, вокруг которого можно описать окружность.\n" +
                        "Периметр: %.1f, , площадь: %.1f. Радиус описанной окружности: %.1f.",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare(), getCircumcircle());
    }
}
