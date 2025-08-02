package ru.lectures.Patterns.CreationalPatterns.Singleton.Director;

public class DirectorTest {
    public static void main(String[] args) {
        Director director1 = Director.getInstance();
        director1.checkShop("ArtPlay");
    }
}
