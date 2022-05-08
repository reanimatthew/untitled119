package com.company.shape;

import java.math.BigDecimal;

public class TriangleRightBuilder {
    private BigDecimal firstCathetus;
    private BigDecimal secondCathetus;

    public TriangleRightBuilder firstCathetus(BigDecimal firstCathetus) {
        this.firstCathetus = firstCathetus;
        return this;
    }

    public TriangleRightBuilder secondCathetus (BigDecimal secondCathetus) {
        this.secondCathetus = secondCathetus;
        return this;
    }

    public TriangleRight build() {
        return new TriangleRight(firstCathetus, secondCathetus);
    }

}
