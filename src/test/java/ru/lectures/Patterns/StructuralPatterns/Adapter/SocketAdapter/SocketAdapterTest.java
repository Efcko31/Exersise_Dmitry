package ru.lectures.Patterns.StructuralPatterns.Adapter.SocketAdapter;

public class SocketAdapterTest {
    public static void main(String[] args) {
        AmericanSocket usSocket = new AmericanSocket();
        EuropeanSocket adapter = new SocketAdapter(usSocket);

        adapter.pugInEurope();
    }
}
