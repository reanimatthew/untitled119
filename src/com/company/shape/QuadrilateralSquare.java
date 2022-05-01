package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

class QuadrilateralSquare extends Quadrilateral implements SameSidesSameAngles {

    QuadrilateralSquare(BigDecimal firstSide) {
        super(firstSide, firstSide, firstSide, firstSide, new BigDecimal("90"), new BigDecimal("90"));
    }

    @Override
    public BigDecimal getSquare() {
        return firstSide.multiply(firstSide);
    }

    @Override
    public BigDecimal getCircumcircle() {
        return BigDecimalMath.sqrt(new BigDecimal("2"), new MathContext(50)).multiply(firstSide).divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getIncircle() {
        return firstSide.divide(new BigDecimal("2"), 50, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getAngle() {
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
