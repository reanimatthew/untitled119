package com.company.shape;

import java.math.BigDecimal;

public class QuadrilateralBuilder {
    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;
    private BigDecimal fourthSide;
    private BigDecimal firstAngle;
    private BigDecimal secondAngle;

    public QuadrilateralBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public QuadrilateralBuilder secondSide(BigDecimal secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public QuadrilateralBuilder thirdSide(BigDecimal thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public QuadrilateralBuilder fourthSide(BigDecimal fourthSide) {
        this.fourthSide = fourthSide;
        return this;
    }

    public QuadrilateralBuilder firstAngle(BigDecimal firstAngle) {
        this.firstAngle = firstAngle;
        return this;
    }

    public QuadrilateralBuilder secondAngle(BigDecimal secondAngle) {
        this.secondAngle = secondAngle;
        return this;
    }

    public Quadrilateral build() {
        return new Quadrilateral(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }
}