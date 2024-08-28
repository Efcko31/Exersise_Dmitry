package ru.Oop.Shapes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends Shape {
    protected Integer[] a;
    protected Integer[] b;
    protected Integer[] c;
public Rectangle(String color, Integer[] a, Integer[] b, Integer[] c) {
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
