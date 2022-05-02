package com.company.shape;

import java.math.BigDecimal;
import java.util.Locale;

public class TriangleEquilateral extends Triangle implements SameSidesSameAngles {

    TriangleEquilateral(BigDecimal firstSide) {
        super(firstSide, firstSide, firstSide);
    }

    @Override
    public BigDecimal getAngle() {
        return BIG_DECIMAL_60;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "равносторонний треугольник со сторонами равными: %.1f, периметром: %.1f, площадью: %.1f.\n" +
                        "Радиус вписанной окружности равен: %.1f, а описанной: %.1f.\n" +
                        "Это правильный многоугольник, его углы равны %.0f°.\n",
                firstSide, getPerimeter(), getSquare(), getIncircle(), getCircumcircle(), getAngle());
    }
}
