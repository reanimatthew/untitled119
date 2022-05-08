package com.company.shape;

import java.math.BigDecimal;

public class TriangleBuilder {
    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;

    public TriangleBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public TriangleBuilder secondSide(BigDecimal secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public TriangleBuilder thirdSide(BigDecimal thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public Triangle builder() {
        return new Triangle(firstSide, secondSide, thirdSide);
    }

}
