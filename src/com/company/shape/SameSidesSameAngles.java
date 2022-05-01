package com.company.shape;

import java.math.BigDecimal;

interface SameSidesSameAngles extends Perimeter, Square, Incircle, Circumcircle {
    BigDecimal getAngle();
}
