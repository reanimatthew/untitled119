package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

public class Quadrilateral implements Perimeter, Square {
    BigDecimal firstSide;
    BigDecimal secondSide;
    BigDecimal thirdSide;
    BigDecimal fourthSide;
    BigDecimal firstAngle;
    BigDecimal secondAngle;

    Quadrilateral(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide, BigDecimal fourthSide, BigDecimal firstAngle, BigDecimal secondAngle) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.fourthSide = fourthSide;
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
    }


    @Override
    public BigDecimal getPerimeter() {
        return firstSide.add(secondSide).add(thirdSide).add(fourthSide);
    }

    @Override
    public BigDecimal getSquare() {
        return BigDecimalMath.sqrt(
                (getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(firstSide)).multiply(
                                getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(secondSide)).multiply(
                                getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(thirdSide)).multiply(
                                getPerimeter().divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP).subtract(fourthSide)).
                        subtract(
                                firstSide.multiply(secondSide).multiply(thirdSide).multiply(fourthSide).multiply(
                                        BigDecimalMath.pow(
                                                BigDecimalMath.cos(
                                                        firstAngle.add(secondAngle).multiply(Circle.PI).divide(new BigDecimal("180"), 50, RoundingMode.HALF_UP)
                                                                .divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP), new MathContext(50)
                                                ), 2, new MathContext(50)))),
                new MathContext(50));
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник со сторонами: %.1f, %.1f, %.1f, %.1f, периметром %.1f, и площадью %.1f.",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare());
    }
}
