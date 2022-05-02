package com.company;

import com.company.shape.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Menu extends Thread {
    ArrayList<Shape> figures = new ArrayList<>();
    ComparatorBySquare bySquare = new ComparatorBySquare();
    ComparatorByPerimeter byPerimeter = new ComparatorByPerimeter();
    ComparatorByType byType = new ComparatorByType();
    ComparatorByCorners byCorners = new ComparatorByCorners();

    public void addPrintSort(Shape figure) {
        figures.add(figure);
        System.out.println("Создан " + figure + "\n");
        figures.sort(bySquare);
        figures.sort(byPerimeter);
        figures.sort(byType);
        figures.sort(byCorners);
        System.out.println(figures);
    }

    @Override
    public void run() {
        BigDecimal sideOrRadius;
        BigDecimal secondSide;
        BigDecimal thirdSide;
        BigDecimal fourthSide;
        BigDecimal angle;
        BigDecimal nextAngle;
        BigDecimal numberOfSides;
        boolean go = true;

        Scanner scanner = new Scanner(System.in);

        while (go) {
            System.out.println("Выберите фигуру:\n" +
                    "1. Круг\n" +
                    "2. Треугольник\n" +
                    "3. Четырехугольник\n" +
                    "4. Правильный n-угольник\n" +
                    "5. Выход");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Введите радиус:");
                    sideOrRadius = scanner.nextBigDecimal();
                    try {
                        addPrintSort(FactoryShapes.GiveMeCircle(sideOrRadius));
                    } catch (IllegalFigureException e) {
                        System.out.println("Неправильные входные данные\n");
                    }
                    break;
                case 2:
                    System.out.println("Как будете создавать треугольник?\n" +
                            "1. По 3-м сторонам\n" +
                            "2. По 2-м сторонам и углу между ними\n" +
                            "3. По стороне и прилегающим углам");
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println("Введите три стороны:");
                            sideOrRadius = scanner.nextBigDecimal();
                            secondSide = scanner.nextBigDecimal();
                            thirdSide = scanner.nextBigDecimal();
                            try {
                                addPrintSort(FactoryShapes.GiveMeTriangle(sideOrRadius, secondSide, thirdSide));
                            } catch (IllegalFigureException e) {
                                System.out.println("Неправильные входные данные\n");
                            }
                            break;
                        case 2:
                            System.out.println("Введите 2 стороны и угол:");
                            sideOrRadius = scanner.nextBigDecimal();
                            secondSide = scanner.nextBigDecimal();
                            angle = scanner.nextBigDecimal();
                            try {
                                addPrintSort(FactoryShapes.GiveMeTriangleOneAngle(sideOrRadius, secondSide, angle));
                            } catch (IllegalFigureException e) {
                                System.out.println("Неправильные входные данные\n");
                            }
                            break;
                        case 3:
                            System.out.println("Введите сторону и 2 угла:");
                            sideOrRadius = scanner.nextBigDecimal();
                            angle = scanner.nextBigDecimal();
                            nextAngle = scanner.nextBigDecimal();
                            try {
                                addPrintSort(FactoryShapes.GiveMeTriangleTwoAngles(sideOrRadius, angle, nextAngle));
                            } catch (IllegalFigureException e) {
                                System.out.println("Неправильные входные данные\n");
                            }
                            break;
                        default:
                            System.out.println("Нет такого пункта меню");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Введите 4 стороны и 2 противолежащих угла:");
                    sideOrRadius = scanner.nextBigDecimal();
                    secondSide = scanner.nextBigDecimal();
                    thirdSide = scanner.nextBigDecimal();
                    fourthSide = scanner.nextBigDecimal();
                    angle = scanner.nextBigDecimal();
                    nextAngle = scanner.nextBigDecimal();
                    try {
                        addPrintSort(FactoryShapes.GiveMeQuadrilateral(sideOrRadius, secondSide, thirdSide, fourthSide, angle, nextAngle));
                    } catch (IllegalFigureException e) {
                        System.out.println("Неправильные входные данные\n");
                    }
                    break;
                case 4:
                    System.out.println("Введите сторону и число сторон:");
                    sideOrRadius = scanner.nextBigDecimal();
                    numberOfSides = scanner.nextBigDecimal();
                    try {
                        addPrintSort(FactoryShapes.GiveMeRegularPolygon(sideOrRadius, numberOfSides));
                    } catch (IllegalFigureException e) {
                        System.out.println("Неправильные входные данные\n");
                    }
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }
    }
}
