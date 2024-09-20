package ru.Oop.OnlineStoreVerdion2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String login;
    private String password;
    private  Basket basket;

    public void printBasket() {
        System.out.printf("\nПользователь: %s\nВ корзине: \n", login );
        basket.print();
    }

}
