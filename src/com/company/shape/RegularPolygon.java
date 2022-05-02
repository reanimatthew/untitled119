package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

public class RegularPolygon implements SameSidesSameAngles {
    BigDecimal side;
    BigDecimal numberOfSides;

    public RegularPolygon(BigDecimal side, BigDecimal numberOfSides) {
        this.side = side;
        this.numberOfSides = numberOfSides;
    }

    @Override
    public BigDecimal getCircumcircle() {
        return getIncircle().divide(
                BigDecimalMath.cos(
                        Circle.PI.divide(numberOfSides, 50, RoundingMode.HALF_UP), MATH_CONTEXT_50), 50, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getIncircle() {
        return getSquare().multiply(BIG_DECIMAL_2).divide(getPerimeter(), 50, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getPerimeter() {
        return side.multiply(numberOfSides);
    }

    @Override
    public BigDecimal getSquare() {
        return numberOfSides.
                divide(new BigDecimal("4"), 50, RoundingMode.HALF_UP).
                divide(BigDecimalMath.tan(
                        Circle.PI.divide(numberOfSides, 50, RoundingMode.HALF_UP), MATH_CONTEXT_50
                ), 50, RoundingMode.HALF_UP)
                .multiply(side.pow(2));
    }

    @Override
    public BigDecimal getAngle() {
        return BIG_DECIMAL_180.multiply(numberOfSides.subtract(BIG_DECIMAL_2)).divide(numberOfSides, 50, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "многоугольник с %.0f сторонами, равными %.1f, периметром: %.1f и площадью %.1f.\n" +
                        "Радиус вписанной окружности: %.1f, радиус описанной окружности: %.1f.\n" +
                        "Это правильный многоугольник с углами, равными %.0f°.\n",
                numberOfSides, side, getPerimeter(), getSquare(), getIncircle(), getCircumcircle(), getAngle());
    }

    public BigDecimal getNumberOfCorners() {
        return numberOfSides;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
