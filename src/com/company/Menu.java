package com.company;

import com.company.shape.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Thread {
    ArrayList<Shape> figures = new ArrayList<>();

    @Override
    public void run() {
        BigDecimal sideOrRadius;
        BigDecimal secondSide;
        BigDecimal thirdSide;
        BigDecimal fourthSide;
        BigDecimal angle;
        BigDecimal nextAngle;
        BigDecimal numberOfSides;
        Shape figure;
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
                        figure = FactoryShapes.GiveMeCircle(sideOrRadius);
                        figures.add(figure);
                        System.out.println("Создан " + figure + "\n");
                    } catch (IllegalFigure e) {
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
                                figure = FactoryShapes.GiveMeTriangle(sideOrRadius, secondSide, thirdSide);
                                figures.add(figure);
                                System.out.println("Создан " + figure + "\n");
                            } catch (IllegalFigure e) {
                                System.out.println("Неправильные входные данные\n");
                            }
                            break;
                        case 2:
                            System.out.println("Введите 2 стороны и угол:");
                            sideOrRadius = scanner.nextBigDecimal();
                            secondSide = scanner.nextBigDecimal();
                            angle = scanner.nextBigDecimal();
                            try {
                                figure = FactoryShapes.GiveMeTriangleOneAngle(sideOrRadius, secondSide, angle);
                                figures.add(figure);
                                System.out.println("Создан " + figure + "\n");
                            } catch (IllegalFigure e) {
                                System.out.println("Неправильные входные данные\n");
                            }
                            break;
                        case 3:
                            System.out.println("Введите сторону и 2 угла:");
                            sideOrRadius = scanner.nextBigDecimal();
                            angle = scanner.nextBigDecimal();
                            nextAngle = scanner.nextBigDecimal();
                            try {
                                figure = FactoryShapes.GiveMeTriangleTwoAngles(sideOrRadius, angle, nextAngle);
                                figures.add(figure);
                                System.out.println("Создан " + figure + "\n");
                            } catch (IllegalFigure e) {
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
                        figure = FactoryShapes.GiveMeQuadrilateral(sideOrRadius, secondSide, thirdSide, fourthSide, angle, nextAngle);
                        figures.add(figure);
                        System.out.println("Создан " + figure + "\n");
                    } catch (IllegalFigure e) {
                        System.out.println("Неправильные входные данные\n");
                    }
                    break;
                case 4:
                    System.out.println("Введите сторону и число сторон:");
                    sideOrRadius = scanner.nextBigDecimal();
                    numberOfSides = scanner.nextBigDecimal();
                    try {
                        figure = FactoryShapes.GiveMeRegularPolygon(sideOrRadius, numberOfSides);
                        figures.add(figure);
                        System.out.println("Создан " + figure + "\n");
                    } catch (IllegalFigure e) {
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
