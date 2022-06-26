package com.company;

import com.company.shape.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Menu extends Thread {
    ArrayList<Shape> figures = new ArrayList<>();
    /*ComparatorBySquare bySquare = new ComparatorBySquare();
    ComparatorByPerimeter byPerimeter = new ComparatorByPerimeter();
    ComparatorByType byType = new ComparatorByType();
    ComparatorByCorners byCorners = new ComparatorByCorners();
    Comparator<Shape> comparator = byCorners.thenComparing(byType).thenComparing(byPerimeter).thenComparing(bySquare); //ВОТ ТАК НАДО ПИСАТЬ!*/
    public void addPrintSort(Shape figure) {
        figures.add(figure);
        System.out.println("Создан " + figure + "\n");
        //figures.sort(comparator);
        figures.sort(ComparatorForFigures.GetFiguresComparator());
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
            /*System.out.println("Выберите фигуру:\n" +
                    "1. Круг\n" +
                    "2. Треугольник\n" +
                    "3. Четырехугольник\n" +
                    "4. Правильный n-угольник\n" +
                    "5. Показать уже созданные фигуры\n" +
                    "6. Выход");*/

            MenuFabric.showMenu();

            Integer number = scanner.nextInt();
            switch (MenuFabric.getFigure(number)) {
                case "Круг":
                    System.out.println("Введите радиус:");
                    sideOrRadius = scanner.nextBigDecimal();
                    try {
                        addPrintSort(FactoryShapes.GiveMeCircle(sideOrRadius));
                    } catch (IllegalFigureException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Треугольник":
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
                                System.out.println(e.getMessage());
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
                                System.out.println(e.getMessage());
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
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Нет такого пункта меню");
                            break;
                    }
                    break;
                case "Четырехугольник":
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
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Правильный n-угольник":
                    System.out.println("Введите сторону и число сторон:");
                    sideOrRadius = scanner.nextBigDecimal();
                    numberOfSides = scanner.nextBigDecimal();
                    try {
                        addPrintSort(FactoryShapes.GiveMeRegularPolygon(sideOrRadius, numberOfSides));
                    } catch (IllegalFigureException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Показать уже созданные фигуры":
                    System.out.println("Что показать?\n" +
                            "1. Все фигуры\n" +
                            "2. Круги\n" +
                            "3. Треугольники\n" +
                            "4. Четырехугольники\n" +
                            "5. N-угольники\n" +
                            "6. Круги и n-угольники\n" +
                            "7. Треугольники и четырехугольники\n" +
                            "8. Суммарное количество всех углов во всех фигурах");
                    switch (scanner.nextInt()) {
                        case 1:
                            FiguresWereMade.showAllFigures(figures);
                            break;
                        case 2:
                            FiguresWereMade.showCircles(figures);
                            break;
                        case 3:
                            FiguresWereMade.showTriangles(figures);
                            break;
                        case 4:
                            FiguresWereMade.showQuadrilaterals(figures);
                            break;
                        case 5:
                            FiguresWereMade.showRegularPolygons(figures);
                            break;
                        case 6:
                            FiguresWereMade.showCirclesAndRegularPolygons(figures);
                            break;
                        case 7:
                            FiguresWereMade.showTrianglesAndQuadrilaterals(figures);
                            break;
                        case 8:
                            FiguresWereMade.showSumOfAllCorners(figures);
                            break;
                        default:
                            System.out.println("Нет такого пункта меню");
                            break;
                    }
                    break;
                case "Выход":
                    go = false;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }
    }
}
