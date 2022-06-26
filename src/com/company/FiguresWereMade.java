package com.company;

import com.company.shape.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FiguresWereMade {

    public static void showAllFigures(List<Shape> shapes) {
        shapes.forEach(System.out::println);
    }

    public static void showCircles(List<Shape> shapes) {
        shapes.stream().filter(shape -> shape instanceof Circle).forEach(System.out::println);
    }

    public static void showTriangles(List<Shape> shapes) {
        shapes.stream().filter(shape -> shape instanceof Triangle).forEach(System.out::println);
    }

    public static void showQuadrilaterals(List<Shape> shapes) {
        shapes.stream().filter(shape -> shape instanceof Quadrilateral).forEach(System.out::println);
    }

    public static void showRegularPolygons(List<Shape> shapes) {
        shapes.stream().filter(shape -> shape.getClass().equals(RegularPolygon.class)).forEach(System.out::println);
    }

    public static void showCirclesAndRegularPolygons(List<Shape> shapes) {
        shapes.stream().filter(shape -> shape.getClass().equals(Circle.class) || shape.getClass().equals(RegularPolygon.class)).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void showTrianglesAndQuadrilaterals(List<Shape> shapes) {
        shapes.stream().filter(shape -> shape instanceof Triangle || shape instanceof Quadrilateral).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void showSumOfAllCorners(List<Shape> shapes) {
        System.out.println(shapes.stream().map(Shape::getNumberOfCorners).map(BigDecimal::intValue).reduce(Integer::sum).orElse(0));
    }
}
