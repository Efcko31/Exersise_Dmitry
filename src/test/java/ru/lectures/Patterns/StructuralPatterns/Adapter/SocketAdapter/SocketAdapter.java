package ru.lectures.Patterns.StructuralPatterns.Adapter.SocketAdapter;

public class SocketAdapter implements EuropeanSocket {
    private AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void pugInEurope() {
        System.out.println("Адаптер преобразует разьем");
        americanSocket.plugInAmericanSocket();
    }
}
