package com.company.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DegreesToRadians {
    public static BigDecimal toRadians(BigDecimal angle) {
        return angle.multiply(Circle.PI).divide(new BigDecimal("180"), 50, RoundingMode.HALF_UP);
    }
}
