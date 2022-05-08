package com.company.shape;

import java.math.BigDecimal;

public class QuadrilateralTangentialBuilder {

    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;
    private BigDecimal fourthSide;
    private BigDecimal firstAngle;
    private BigDecimal secondAngle;

    public QuadrilateralTangentialBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public QuadrilateralTangentialBuilder secondSide(BigDecimal secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public QuadrilateralTangentialBuilder thirdSide(BigDecimal thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public QuadrilateralTangentialBuilder fourthSide(BigDecimal fourthSide) {
        this.fourthSide = fourthSide;
        return this;
    }

    public QuadrilateralTangentialBuilder firstAngle(BigDecimal firstAngle) {
        this.firstAngle = firstAngle;
        return this;
    }

    public QuadrilateralTangentialBuilder secondAngle(BigDecimal secondAngle) {
        this.secondAngle = secondAngle;
        return this;
    }

    public QuadrilateralTangential build() {
        return new QuadrilateralTangential(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }


}
