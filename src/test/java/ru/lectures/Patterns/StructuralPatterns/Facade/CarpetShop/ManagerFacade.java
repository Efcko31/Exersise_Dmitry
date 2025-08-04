package ru.lectures.Patterns.StructuralPatterns.Facade.CarpetShop;

import lombok.Data;


public class ManagerFacade {
    private Warehouse warehouse;
    private CheckingConditionCarpet checkingConditionCarpet;
    private Packaging packaging;
    private Logistics logistics;
    private Delivery delivery;
    private Driver driver;

    public ManagerFacade() {
        this.warehouse = new Warehouse();
        this.checkingConditionCarpet = new CheckingConditionCarpet();
        this.packaging = new Packaging();
        this.logistics = new Logistics();
        this.driver = new Driver();
        this.delivery = new Delivery();
    }

    public void placeAnOrder() {
        orderReceived();
        warehouse.carpetChek();
        checkingConditionCarpet.carpetInspection();
        packaging.packCarpet();
        logistics.setRoute();
        delivery.deliverOrderCustomer();
        driver.receiveDeliveryOrder();
    }

    void orderReceived() {
        System.out.println("Заказ успешно оформлен!");
    }
}
