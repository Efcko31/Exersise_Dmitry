package ru.Oop.Shapes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends Shape {
    private Coordinate a;
    private Coordinate b;
    private Coordinate c;

    public Rectangle(String color, Coordinate a, Coordinate b, Coordinate c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void draw() {
        System.out.printf("Рисует треугольник цвет: %s\n", color);
    }
}
