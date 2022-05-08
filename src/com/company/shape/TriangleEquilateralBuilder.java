package com.company.shape;

import java.math.BigDecimal;

public class TriangleEquilateralBuilder {
    private BigDecimal firstSide;

    public TriangleEquilateralBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public TriangleEquilateral build() {
        return new TriangleEquilateral(firstSide);
    }
}
