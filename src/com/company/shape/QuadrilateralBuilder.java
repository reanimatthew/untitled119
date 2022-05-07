package com.company.shape;

import java.math.BigDecimal;

public class QuadrilateralBuilder {
    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;
    private BigDecimal fourthSide;
    private BigDecimal firstAngle;
    private BigDecimal secondAngle;

    public QuadrilateralBuilder setFirstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public QuadrilateralBuilder setSecondSide(BigDecimal secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public QuadrilateralBuilder setThirdSide(BigDecimal thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public QuadrilateralBuilder setFourthSide(BigDecimal fourthSide) {
        this.fourthSide = fourthSide;
        return this;
    }

    public QuadrilateralBuilder setFirstAngle(BigDecimal firstAngle) {
        this.firstAngle = firstAngle;
        return this;
    }

    public QuadrilateralBuilder setSecondAngle(BigDecimal secondAngle) {
        this.secondAngle = secondAngle;
        return this;
    }

    public Quadrilateral createQuadrilateral() {
        return new Quadrilateral(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }
}