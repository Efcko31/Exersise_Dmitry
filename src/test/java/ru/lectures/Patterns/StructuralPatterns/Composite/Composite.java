package ru.lectures.Patterns.StructuralPatterns.Composite;

public class Composite {
    //Объединяет объекты в древовидные структуры, позволяя клиенту работать с ними как с одним объектом.
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        root.add(new File("file1.txt"));
        root.add(new File("file2.txt"));

        Directory subDir = new Directory("Subfolder");
        subDir.add(new File("file3.txt"));
        root.add(subDir);

        root.print();

        // + Упрощает работу с древовидными структурами.
        // - Сложно ограничить типы компонентов.
    }
}
