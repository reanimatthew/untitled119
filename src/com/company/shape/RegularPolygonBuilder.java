package com.company.shape;

import java.math.BigDecimal;

public class RegularPolygonBuilder {
    private BigDecimal side;
    private BigDecimal numberOfSides;

    public RegularPolygonBuilder side(BigDecimal side) {
        this.side = side;
        return this;
    }

    public RegularPolygonBuilder numberOfSides(BigDecimal numberOfSides) {
        this.numberOfSides = numberOfSides;
        return this;
    }

    public RegularPolygon build() {
        return new RegularPolygon(side, numberOfSides);
    }
}