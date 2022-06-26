package com.company.shape;

import com.company.NotInMenu;

import java.math.BigDecimal;
import java.util.Locale;

public class Circle implements Square, Perimeter {
    private final Double type = 0.;
    private final BigDecimal radius;


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
        return radius.pow(2).multiply(PI);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "круг с радиусом %.1f, периметром %.1f и площадью %.1f.\n", radius, getPerimeter(), getSquare());
    }

    @Override
    public BigDecimal getNumberOfCorners() {
        return BIG_DECIMAL_0;
    }

    @Override
    public Double getType() {
        return type;
    }

}
