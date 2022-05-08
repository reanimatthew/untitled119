package com.company.shape;

import java.math.BigDecimal;

public class QuadrilateralSquareBuilder {
    private BigDecimal firstSide;

    public QuadrilateralSquareBuilder firstSide(BigDecimal firstSide) {
        this.firstSide = firstSide;
        return this;
    }

    public QuadrilateralSquare build() {
        return new QuadrilateralSquare(firstSide);
    }
}