package com.company.shape;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.company.shape.Shape.*;

public class FactoryShapes {

    public static Circle GiveMeCircle(BigDecimal radius) {
        notNullAndMinus(radius);

        return new Circle(radius);
    }


    public static Triangle GiveMeTriangle(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide) throws IllegalFigureException {
        notNullAndMinus(firstSide, secondSide, thirdSide);

        if ((firstSide.compareTo(secondSide.add(thirdSide)) >= 0) ||
                (secondSide.compareTo(firstSide.add(thirdSide)) >= 0) ||
                (thirdSide.compareTo(firstSide.add(secondSide)) >= 0))
            throw new IllegalFigureException("Треугольник построить нельзя.\nОдна из сторон больше или равна сумме двух других.");


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
        notNullAndMinus(firstSide, secondSide, angle);

        if (BIG_DECIMAL_180.compareTo(angle) <= 0)
            throw new IllegalFigureException("Треугольник построить нельзя.\nУгол не может быть больше или равен 180°.");


        if ((firstSide.compareTo(secondSide) == 0) && (BIG_DECIMAL_60.compareTo(angle) == 0))
            return new TriangleEquilateral(firstSide);

        if (BIG_DECIMAL_90.compareTo(angle) == 0)
            return new TriangleRight(firstSide, secondSide);

        return GiveMeTriangle(firstSide,
                secondSide,
                BigDecimalMath.sqrt(
                        firstSide.pow(2).add(secondSide.pow(2)).subtract(BIG_DECIMAL_2.multiply(firstSide).multiply(secondSide).multiply(
                                BigDecimalMath.cos(DegreesToRadians.toRadians(angle), MATH_CONTEXT_50))), MATH_CONTEXT_50));
    }

    public static Triangle GiveMeTriangleTwoAngles(BigDecimal firstSide, BigDecimal secondAngle, BigDecimal thirdAngle) {
        notNullAndMinus(firstSide, secondAngle, thirdAngle);

        if (BIG_DECIMAL_180.compareTo(secondAngle.add(thirdAngle)) <= 0)
            throw new IllegalFigureException("Треугольник построить нельзя.\nСумма 2-х углов не может быть больше или равна 180°.");


        if ((BIG_DECIMAL_60.compareTo(secondAngle) == 0) && (BIG_DECIMAL_60.compareTo(thirdAngle) == 0))
            return new TriangleEquilateral(firstSide);

        if (((BIG_DECIMAL_90.compareTo(secondAngle) == 0) && (BIG_DECIMAL_90.compareTo(thirdAngle) != 0)) ||
                ((BIG_DECIMAL_90.compareTo(secondAngle) != 0) && (BIG_DECIMAL_90.compareTo(thirdAngle) == 0)))
            return new TriangleRight(firstSide,
                    firstSide.multiply(BigDecimalMath.tan(
                            DegreesToRadians.toRadians(BIG_DECIMAL_180.subtract(secondAngle).subtract(thirdAngle)), MATH_CONTEXT_50), MATH_CONTEXT_50));

        if (BIG_DECIMAL_90.compareTo(BIG_DECIMAL_180.subtract(secondAngle).subtract(thirdAngle)) == 0)
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
        notNullAndMinus(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        BigDecimal perimeter = firstSide.add(secondSide).add(thirdSide).add(fourthSide);
        if (firstSide.compareTo(perimeter.subtract(firstSide)) >= 0 ||
                secondSide.compareTo(perimeter.subtract(secondSide)) >= 0 ||
                thirdSide.compareTo(perimeter.subtract(thirdSide)) >= 0 ||
                fourthSide.compareTo(perimeter.subtract(fourthSide)) >= 0)
            throw new IllegalFigureException("Четырехугольник построить нельзя.\nОдна сторона не может быть больше суммы остальных.");


        if ((firstSide.compareTo(secondSide) == 0) &&
                (BIG_DECIMAL_90.compareTo(firstAngle) == 0) &&
                (BIG_DECIMAL_90.compareTo(secondAngle) == 0))
            return new QuadrilateralSquare(firstSide);

        boolean conditionQC = (firstSide.multiply(secondSide).add(thirdSide.multiply(fourthSide)))
                .compareTo(firstSide.multiply(thirdSide).add(secondSide.multiply(fourthSide))) == 0;

        boolean conditionQT = (BIG_DECIMAL_90.compareTo(firstSide) == 0) &&
                (BIG_DECIMAL_90.compareTo(secondAngle) == 0);

        if (conditionQC && conditionQT)
            return new QuadrilateralBicentric(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        if (conditionQC)
            return new QuadrilateralCyclic(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        if (conditionQT)
            return new QuadrilateralTangential(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        return new QuadrilateralBuilder().setFirstSide(firstSide).setSecondSide(secondSide).setThirdSide(thirdSide).setFourthSide(fourthSide).setFirstAngle(firstAngle).setSecondAngle(secondAngle).createQuadrilateral();
    }


    public static RegularPolygon GiveMeRegularPolygon(BigDecimal side, BigDecimal numberOfSides) throws IllegalFigureException {
        notNullAndMinus(side, numberOfSides);

        return new RegularPolygon(side, numberOfSides);
    }

    private static void notNullAndMinus(BigDecimal... sidesOrAngles) throws IllegalFigureException {
        for (BigDecimal element : sidesOrAngles
        ) {
            if (element == null || BIG_DECIMAL_0.compareTo(element) >= 0)
                throw new IllegalFigureException("Ошибка!\nФигуру нельзя построить - радиусы и/или стороны и/или углы меньше или равны нулю.");
        }
    }
}
