package com.company.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

class QuadrilateralCyclic extends Quadrilateral implements Incircle {

    QuadrilateralCyclic(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide, BigDecimal fourthSide, BigDecimal firstAngle, BigDecimal secondAngle) {
        super(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }

    @Override
    public BigDecimal getIncircle() {
        return getSquare().multiply(BIG_DECIMAL_2).divide(getPerimeter(), 50, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник, со сторонами: %.1f, %.1f, %.1f, %.1f, в который можно вписать окружность.\n" +
                "Периметр: %.1f, площадь: %.1f.\n" +
                "Радиус вписанной окружности: %.1f.\n",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare(), getIncircle());
    }
}
