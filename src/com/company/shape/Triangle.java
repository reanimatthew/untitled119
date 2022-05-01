package com.company.shape;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

import ch.obermuhlner.math.big.*;

public class Triangle implements Perimeter, Square, Incircle, Circumcircle {
    BigDecimal firstSide;
    BigDecimal secondSide;
    BigDecimal thirdSide;

    Triangle(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    /*Triangle(BigDecimal firstSide, BigDecimal secondSide, BigDecimal angle, String marker) {    // angle between sides
        this(firstSide,
                secondSide,
                BigDecimalMath.sqrt(
                        firstSide.pow(2).
                                add(secondSide.pow(2)).
                                add(firstSide.multiply(secondSide).multiply(BigDecimalMath.cos(
                                        angle.multiply(Circle.PI).divide(new BigDecimal("180"), 50, RoundingMode.HALF_UP), new MathContext(50)
                                ))), new MathContext(50)));
    }*/

    @Override
    public BigDecimal getCircumcircle() {
        return firstSide.multiply(secondSide).
                multiply(thirdSide).
                divide(getSquare(), 50, RoundingMode.HALF_UP).
                divide(new BigDecimal("4"), 50, RoundingMode.HALF_UP);

    }

    @Override
    public BigDecimal getIncircle() {
        return getSquare().divide(getPerimeter(), 50, RoundingMode.HALF_UP).
                multiply(new BigDecimal(2)
                );
    }

    @Override
    public BigDecimal getPerimeter() {
        return firstSide.add(secondSide).add(thirdSide);
    }

    @Override
    public BigDecimal getSquare() {
        BigDecimal halfPerimeter = getPerimeter().divide(new BigDecimal(2), 50, RoundingMode.HALF_UP);
        return BigDecimalMath.sqrt(
                (halfPerimeter.multiply(halfPerimeter.subtract(firstSide)).
                        multiply(halfPerimeter.subtract(secondSide)).
                        multiply(halfPerimeter.subtract(thirdSide))),
                new MathContext(50)
        );

    }

    BigDecimal toRadians(BigDecimal degrees) {
        return degrees.multiply(Circle.PI).divide(new BigDecimal("180"), 50, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "треугольник со сторонами: %.1f, %.1f, %.1f, периметром %.1f, площадью %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f",
                firstSide, secondSide, thirdSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle());
    }
}
