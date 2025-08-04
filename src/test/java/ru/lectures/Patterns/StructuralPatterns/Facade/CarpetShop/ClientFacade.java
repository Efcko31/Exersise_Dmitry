package ru.lectures.Patterns.StructuralPatterns.Facade.CarpetShop;

public class ClientFacade {
    public static void main(String[] args) {
        ManagerFacade managerFacade = new ManagerFacade();
        managerFacade.placeAnOrder();
    }
}
