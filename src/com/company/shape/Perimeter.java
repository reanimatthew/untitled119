package com.company.shape;

import java.math.BigDecimal;

interface Perimeter extends Shape {
    @Override
    BigDecimal getPerimeter();
}
