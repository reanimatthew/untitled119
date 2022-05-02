package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.company.shape.Shape.*;

public class FactoryShapes {

    public static Circle GiveMeCircle(BigDecimal radius) throws IllegalFigureException {
        if (radius.compareTo(new BigDecimal(0)) < 0)
            throw new IllegalFigureException();
        else
            return new Circle(radius);
    }


    public static Triangle GiveMeTriangle(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide) throws IllegalFigureException {
        if ((firstSide.compareTo(secondSide.add(thirdSide)) >= 0) ||
                (secondSide.compareTo(firstSide.add(thirdSide)) >= 0) ||
                (thirdSide.compareTo(firstSide.add(secondSide)) >= 0))
            throw new IllegalFigureException();

        if ((firstSide.compareTo(secondSide) == 0) && (secondSide.compareTo(thirdSide) == 0)) {
            return new TriangleEquilateral(firstSide);
        }

        BigDecimal hypotenuse = firstSide.max(secondSide.max(thirdSide));
        BigDecimal firstCathetus = firstSide.min(secondSide.min(thirdSide));
        BigDecimal secondCathetus = firstSide.add(secondSide).add(thirdSide).subtract((hypotenuse.add(firstCathetus)));
        if (hypotenuse.pow(2).compareTo(firstCathetus.pow(2).add(secondCathetus.pow(2))) == 0)
            return new TriangleRight(firstCathetus, secondCathetus);

        return new Triangle(firstSide, secondSide, thirdSide);
    }

    public static Triangle GiveMeTriangleOneAngle(BigDecimal firstSide, BigDecimal secondSide, BigDecimal angle) {
        if ((firstSide.compareTo(secondSide) == 0) && (angle.compareTo(BIG_DECIMAL_60) == 0))
            return new TriangleEquilateral(firstSide);

        if (angle.compareTo(BIG_DECIMAL_90) == 0)
            return new TriangleRight(firstSide, secondSide);

        return GiveMeTriangle(firstSide,
                secondSide,
                BigDecimalMath.sqrt(
                        firstSide.pow(2).
                                add(secondSide.pow(2)).
                                add(firstSide.multiply(secondSide).multiply(BigDecimalMath.cos(DegreesToRadians.toRadians(angle), MATH_CONTEXT_50))), MATH_CONTEXT_50));
    }

    public static Triangle GiveMeTriangleTwoAngles(BigDecimal firstSide, BigDecimal secondAngle, BigDecimal thirdAngle) {
        if ((secondAngle.compareTo(BIG_DECIMAL_60) == 0) && (thirdAngle.compareTo(BIG_DECIMAL_60) == 0))
            return new TriangleEquilateral(firstSide);

        if (((secondAngle.compareTo(BIG_DECIMAL_90) == 0) && (thirdAngle.compareTo(BIG_DECIMAL_90) != 0)) ||
                ((secondAngle.compareTo(BIG_DECIMAL_90) != 0) && (thirdAngle.compareTo(BIG_DECIMAL_90) == 0)))
            return new TriangleRight(firstSide,
                    firstSide.multiply(BigDecimalMath.tan(
                                    DegreesToRadians.toRadians(BIG_DECIMAL_180.subtract(secondAngle).subtract(thirdAngle)), MATH_CONTEXT_50),
                            MATH_CONTEXT_50));

        if (BIG_DECIMAL_180.subtract(secondAngle).subtract(thirdAngle).compareTo(BIG_DECIMAL_90) == 0)
            return new TriangleRight(firstSide.multiply(BigDecimalMath.sin(DegreesToRadians.toRadians(secondAngle), MATH_CONTEXT_50)),
                    firstSide.multiply(BigDecimalMath.sin(DegreesToRadians.toRadians(thirdAngle), MATH_CONTEXT_50)));

        return GiveMeTriangle(firstSide,
                firstSide
                        .multiply(BigDecimalMath.sin(DegreesToRadians.toRadians(secondAngle), MATH_CONTEXT_50), MATH_CONTEXT_50)
                        .divide(BigDecimalMath.sin(DegreesToRadians.toRadians(BIG_DECIMAL_180.subtract(secondAngle).subtract(thirdAngle)), MATH_CONTEXT_50), 50, RoundingMode.HALF_UP),
                firstSide
                        .multiply(BigDecimalMath.sin(DegreesToRadians.toRadians(thirdAngle), MATH_CONTEXT_50), MATH_CONTEXT_50)
                        .divide(BigDecimalMath.sin(DegreesToRadians.toRadians(BIG_DECIMAL_180.subtract(secondAngle).subtract(thirdAngle)), MATH_CONTEXT_50), 50, RoundingMode.HALF_UP));
    }


    public static Quadrilateral GiveMeQuadrilateral(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide, BigDecimal fourthSide, BigDecimal firstAngle, BigDecimal secondAngle) throws IllegalFigureException {
        if ((firstSide.compareTo(secondSide) == 0) &&
                (firstAngle.compareTo(BIG_DECIMAL_90) == 0) &&
                (secondAngle.compareTo(BIG_DECIMAL_90) == 0))
            return new QuadrilateralSquare(firstSide);

        boolean conditionQC = (firstSide.multiply(secondSide).add(thirdSide.multiply(fourthSide)))
                .compareTo(firstSide.multiply(thirdSide).add(secondSide.multiply(fourthSide))) == 0;

        boolean conditionQT = (firstSide.compareTo(BIG_DECIMAL_90) == 0) &&
                (secondAngle.compareTo(BIG_DECIMAL_90) == 0);

        if (conditionQC && conditionQT)
            return new QuadrilateralBicentric(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        if (conditionQC)
            return new QuadrilateralCyclic(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        if (conditionQT)
            return new QuadrilateralTangential(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        return new Quadrilateral(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }


    public static RegularPolygon GiveMeRegularPolygon(BigDecimal side, BigDecimal numberOfSides) throws IllegalFigureException {
        return new RegularPolygon(side, numberOfSides);
    }
}
