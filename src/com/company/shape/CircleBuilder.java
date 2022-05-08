package com.company.shape;

import java.math.BigDecimal;

public class CircleBuilder {
    private BigDecimal radius;

    public CircleBuilder radius(BigDecimal radius) {
        this.radius = radius;
        return this;
    }

    public Circle build() {
        return new Circle(radius);
    }

}
