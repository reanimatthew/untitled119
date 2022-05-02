package com.company.shape;

import java.math.BigDecimal;
import java.math.MathContext;

public interface Shape {
    BigDecimal PI = new BigDecimal("3.14159265358979323846264338327950288419716939937510");
    BigDecimal BIG_DECIMAL_180 = new BigDecimal("180");
    BigDecimal BIG_DECIMAL_90 = new BigDecimal("90");
    BigDecimal BIG_DECIMAL_60 = new BigDecimal("60");
    BigDecimal BIG_DECIMAL_30 = new BigDecimal("30");
    BigDecimal BIG_DECIMAL_2 = new BigDecimal("2");
    MathContext MATH_CONTEXT_50 = new MathContext(50);
    
    BigDecimal getNumberOfCorners();
    String getType();
    BigDecimal getPerimeter();

    BigDecimal getSquare();

}
