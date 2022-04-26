package com.company;

import com.company.shape.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Thread {
    ArrayList<Shape> figures = new ArrayList<>();

    public void addAndPrint(Shape figure) {
        if (figure != null) {
            figures.add(figure);
            System.out.println("Создан " + figure + "\n");
        } else
            System.out.println("Неправильные входные данные\n");
    }

    @Override
    public void run() {
        double sideOrRadius;
        double secondSide;
        double thirdSide;
        double fourthSide;
        float angle;
        float nextAngle;
        int numberOfSides;
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
                    sideOrRadius = scanner.nextDouble();
                    addAndPrint(FactoryShapes.GiveMeCircle(sideOrRadius));
                    break;
                case 2:
                    System.out.println("Как будете создавать треугольник?\n" +
                            "1. По 3-м сторонам\n" +
                            "2. По 2-м сторонам и углу между ними\n" +
                            "3. По стороне и прилегающим углам");
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println("Введите три стороны:");
                            sideOrRadius = scanner.nextDouble();
                            secondSide = scanner.nextDouble();
                            thirdSide = scanner.nextDouble();
                            addAndPrint(FactoryShapes.GiveMeTriangle(sideOrRadius, secondSide, thirdSide));
                            break;
                        case 2:
                            System.out.println("Введите 2 стороны и угол:");
                            sideOrRadius = scanner.nextDouble();
                            secondSide = scanner.nextDouble();
                            angle = scanner.nextFloat();
                            addAndPrint(FactoryShapes.GiveMeTriangle(sideOrRadius, secondSide, angle));
                            break;
                        case 3:
                            System.out.println("Введите сторону и 2 угла:");
                            sideOrRadius = scanner.nextDouble();
                            angle = scanner.nextFloat();
                            nextAngle = scanner.nextFloat();
                            addAndPrint(FactoryShapes.GiveMeTriangle(sideOrRadius, angle, nextAngle));
                            break;
                        default:
                            System.out.println("Нет такого пункта меню");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Введите 4 стороны и 2 противолежащих угла:");
                    sideOrRadius = scanner.nextDouble();
                    secondSide = scanner.nextDouble();
                    thirdSide = scanner.nextDouble();
                    fourthSide = scanner.nextDouble();
                    angle = scanner.nextFloat();
                    nextAngle = scanner.nextFloat();
                    addAndPrint(FactoryShapes.GiveMeQuadrilateral(sideOrRadius, secondSide, thirdSide, fourthSide, angle, nextAngle));
                    break;
                case 4:
                    System.out.println("Введите сторону и число сторон:");
                    sideOrRadius = scanner.nextDouble();
                    numberOfSides = scanner.nextInt();
                    addAndPrint(FactoryShapes.GiveMeRegularPolygon(sideOrRadius, numberOfSides));
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
