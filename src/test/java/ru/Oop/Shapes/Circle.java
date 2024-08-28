package ru.Oop.Shapes;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle extends Shape {
    protected Double radius;

    public Circle(String color, Double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Рисует круг цвет: %s\n", color);
    }
}
