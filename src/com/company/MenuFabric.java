package com.company;

import com.company.shape.Circle;
import com.company.shape.Quadrilateral;
import com.company.shape.RegularPolygon;
import com.company.shape.Triangle;

import java.util.Map;
import java.util.TreeMap;

public class MenuFabric {
    private static final Map<Integer, String> menu = new TreeMap<>();

    private static void makeMenu() {
        int i = 1;
        if (!Circle.class.isAnnotationPresent(NotInMenu.class)) {
            menu.put(i, "Круг");
            i++;
        }

        if (!Triangle.class.isAnnotationPresent(NotInMenu.class)) {
            menu.put(i, "Треугольник");
            i++;
        }

        if (!Quadrilateral.class.isAnnotationPresent(NotInMenu.class)) {
            menu.put(i, "Четырехугольник");
            i++;
        }

        if (!RegularPolygon.class.isAnnotationPresent(NotInMenu.class)) {
            menu.put(i, "Правильный n-угольник");
            i++;
        }

        menu.put(i, "Показать уже созданные фигуры");
        i++;
        menu.put(i, "Выход");
    }

    public static void showMenu() {
        makeMenu();
        menu.forEach((k, v) -> System.out.println(k + ". " + v));
    }

    public static String getFigure(Integer number) {
        return menu.get(number);
    }

}
