package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;
import com.company.NotInMenu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

@NotInMenu
public class Quadrilateral implements Perimeter, Square {
    final Double type = 4.;
    final BigDecimal firstSide;
    final BigDecimal secondSide;
    final BigDecimal thirdSide;
    final BigDecimal fourthSide;
    final BigDecimal firstAngle;
    final BigDecimal secondAngle;

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
                (getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(firstSide))
                        .multiply(getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(secondSide))
                        .multiply(getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(thirdSide))
                        .multiply(getPerimeter().divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP).subtract(fourthSide))
                        .subtract(firstSide.multiply(secondSide).multiply(thirdSide).multiply(fourthSide)
                                .multiply(BigDecimalMath.pow(
                                        BigDecimalMath.cos(
                                                firstAngle.add(secondAngle).multiply(PI).divide(BIG_DECIMAL_180, 50, RoundingMode.HALF_UP)
                                                        .divide(BIG_DECIMAL_2, 50, RoundingMode.HALF_UP), MATH_CONTEXT_50), 2, MATH_CONTEXT_50))), MATH_CONTEXT_50);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "четырехугольник со сторонами: %.1f, %.1f, %.1f, %.1f, периметром %.1f, и площадью %.1f.\n",
                firstSide, secondSide, thirdSide, fourthSide, getPerimeter(), getSquare());
    }

    public BigDecimal getNumberOfCorners() {
        return new BigDecimal("4");
    }

    public Double getType() {
        return type;
    }

}
