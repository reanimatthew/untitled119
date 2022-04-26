package com.company.shape;

public class FactoryShapes {

    public static Circle GiveMeCircle(double radius) {
        if (radius < 0)
            return null;
        else
            return new Circle(radius);
    }


    public static Triangle GiveMeTriangle(double firstSide, double secondSide, double thirdSide) {
        if ((firstSide > secondSide + thirdSide) ||
                (secondSide > firstSide + thirdSide) ||
                (thirdSide > firstSide + secondSide))
            return null;

        if (firstSide == secondSide && secondSide == thirdSide) {
            return new TriangleE(firstSide);
        }

        double hypotenuse = Math.max(firstSide, Math.max(secondSide, thirdSide));
        double firstCathetus = Math.min(firstSide, Math.min(secondSide, thirdSide));
        double secondCathetus = (firstSide + secondSide + thirdSide) - (hypotenuse + firstCathetus);
        if (Math.pow(hypotenuse, 2) == (Math.pow(secondCathetus, 2) + Math.pow(firstCathetus, 2)))
            return new TriangleR(firstCathetus, secondCathetus);

        return new Triangle(firstSide, secondSide, thirdSide);
    }

    public static Triangle GiveMeTriangle(double firstSide, double secondSide, float angle) {
        if (firstSide == secondSide && angle == 60)
            return new TriangleE(firstSide);

        if (angle == 90)
            return new TriangleR(firstSide, secondSide);

        angle = (float) Math.toRadians(angle);
        return GiveMeTriangle(firstSide,
                secondSide,
                Math.sqrt(firstSide * firstSide + secondSide * secondSide + firstSide * secondSide * Math.cos(angle)));
    }

    public static Triangle GiveMeTriangle(double firstSide, float secondAngle, float thirdAngle) {
        if (secondAngle == 60 && thirdAngle == 60)
            return new TriangleE(firstSide);

        if ((secondAngle == 90 && thirdAngle != 90) ||
                (secondAngle != 90 && thirdAngle == 90))
            return new TriangleR(firstSide,
                    firstSide * Math.tan(Math.toRadians(180 - secondAngle - thirdAngle)));

        return GiveMeTriangle(firstSide,
                firstSide * Math.sin(Math.toRadians(secondAngle)) / Math.sin(Math.toRadians(180 - secondAngle - thirdAngle)),
                firstSide * Math.sin(Math.toRadians(thirdAngle)) / Math.sin(Math.toRadians(180 - secondAngle - thirdAngle)));
    }


    public static Quadrilateral GiveMeQuadrilateral(double firstSide, double secondSide, double thirdSide, double fourthSide, float firstAngle, float secondAngle) {
        if (firstSide == secondSide &&
                firstAngle == 90. &&
                secondAngle == 90.)
            return new QuadrilateralS(firstSide);

        boolean conditionQC = firstSide * secondSide + thirdSide * fourthSide == firstSide * thirdSide + secondSide * fourthSide;
        boolean conditionQT = firstAngle == 90. && secondAngle == 90.;

        if (conditionQC && conditionQT)
            return new QuadrilateralB(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        if (conditionQC)
            return new QuadrilateralC(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        if (conditionQT)
            return new QuadrilateralT(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);

        return new Quadrilateral(firstSide, secondSide, thirdSide, fourthSide, firstAngle, secondAngle);
    }


    public static RegularPolygon GiveMeRegularPolygon(double side, int numberOfSides) {
        return new RegularPolygon(side, numberOfSides);
    }
}
