package com.company.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.company.shape.Shape.*;


public class DegreesToRadians {
    public static BigDecimal toRadians(BigDecimal angle) {
        return angle.multiply(PI).divide(BIG_DECIMAL_180, 50, RoundingMode.HALF_UP);
    }
}
