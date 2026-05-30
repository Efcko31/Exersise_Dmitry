package ru.Oop.Shapes;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle extends Shape {
    private Double radius;
    private Coordinate center;

    public Circle(String color, Double radius, Coordinate center) {
        super(color);
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.printf("Рисует круг цвет: %s\n", color);
    }
}
