package ru.Oop.Shapes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShapeTest {
    ArrayList<Shape> shapeArray = new ArrayList<>();
    Circle circle1 = new Circle("Зеленый", 15.0);
    Rectangle rectangle1 = new Rectangle("Красный", new Integer[]{0, 3}, new Integer[]{3, 3}, new Integer[]{3, 0});

    @Test
    public void test() {
        ShapeUtil.addShapesInArray(shapeArray, circle1, rectangle1);

        for (Shape shape : shapeArray) {
            shape.draw();
        }
    }
}
