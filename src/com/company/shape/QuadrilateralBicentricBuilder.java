package com.company.shape;

import java.math.BigDecimal;

public class QuadrilateralBicentricBuilder {
    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;
    private BigDecimal fourthSide;
    private BigDecimal firstAngle;
    private BigDecimal secondAngle;

    public QuadrilateralBicentricBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public QuadrilateralBicentricBuilder secondSide(BigDecimal secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public QuadrilateralBicentricBuilder thirdSide(BigDecimal thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public QuadrilateralBicentricBuilder fourthSide(BigDecimal fourthSide) {
        this.fourthSide = fourthSide;
        return this;
    }

    public QuadrilateralBicentricBuilder firstAngle(BigDecimal firstAngle) {
        this.firstAngle = firstAngle;
        return this;
    }

    public QuadrilateralBicentricBuilder secondAngle(BigDecimal secondAngle) {
        this.secondAngle = secondAngle;
        return this;
    }

    public QuadrilateralBicentric build() {
        return new QuadrilateralBicentric(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }
}
