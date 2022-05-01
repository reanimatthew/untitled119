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
                new BigDecimal("2").multiply(PI)
        );
    }

    @Override
    public BigDecimal getSquare() {
        return radius.pow(2).
                multiply(
                        new BigDecimal("2").multiply(PI)
                );
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "круг с радиусом %.1f, периметром %.1f и площадью %.1f.", radius, getPerimeter(), getSquare());
    }
}
