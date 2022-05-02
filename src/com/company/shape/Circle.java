package com.company.shape;

import java.math.BigDecimal;
import java.util.Locale;

public class Circle implements Square, Perimeter {
    BigDecimal radius;


    Circle(BigDecimal radius) {
        this.radius = radius;
    }


    @Override
    public BigDecimal getPerimeter() {
        return radius.multiply(
                BIG_DECIMAL_2.multiply(PI)
        );
    }

    @Override
    public BigDecimal getSquare() {
        return radius.pow(2).
                multiply(
                        BIG_DECIMAL_2.multiply(PI)
                );
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "круг с радиусом %.1f, периметром %.1f и площадью %.1f.\n", radius, getPerimeter(), getSquare());
    }

    public BigDecimal getNumberOfCorners() {
        return new BigDecimal("0");
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

}
