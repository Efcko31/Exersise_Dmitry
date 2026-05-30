package ru.Oop.Shapes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShapeTest {
    ArrayList<Shape> shapeArray = new ArrayList<>();
    Circle circle = new Circle("Зеленый", 15.0, new Coordinate(5, 5));
    Rectangle rectangle = new Rectangle("Красный", new Coordinate(3, 0), new Coordinate(3, 3), new Coordinate(0, 3));

    @Test
    public void test() {
        shapeArray.add(circle);
        shapeArray.add(rectangle);

        for (Shape shape : shapeArray) {
            shape.draw();
        }
    }
}
