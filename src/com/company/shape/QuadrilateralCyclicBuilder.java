package com.company.shape;

import java.math.BigDecimal;

public class QuadrilateralCyclicBuilder {
    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;
    private BigDecimal fourthSide;
    private BigDecimal firstAngle;
    private BigDecimal secondAngle;

    public QuadrilateralCyclicBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public QuadrilateralCyclicBuilder secondSide(BigDecimal secondSide) {
        this.secondSide = secondSide;
        return this;
    }

    public QuadrilateralCyclicBuilder thirdSide(BigDecimal thirdSide) {
        this.thirdSide = thirdSide;
        return this;
    }

    public QuadrilateralCyclicBuilder fourthSide(BigDecimal fourthSide) {
        this.fourthSide = fourthSide;
        return this;
    }

    public QuadrilateralCyclicBuilder firstAngle(BigDecimal firstAngle) {
        this.firstAngle = firstAngle;
        return this;
    }

    public QuadrilateralCyclicBuilder secondAngle(BigDecimal secondAngle) {
        this.secondAngle = secondAngle;
        return this;
    }

    public QuadrilateralCyclic build() {
        return new QuadrilateralCyclic(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }




}
