package ru.Oop.Shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeUtil {
    public static void addShapesInArray(ArrayList<Shape> shapeArray, Shape... shape) {
        shapeArray.addAll(List.of(shape));
    }
}
