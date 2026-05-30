package ru.StreamApi.Exersises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForEx12 {
    private String customerId;
    private String productId;
    private Integer quantity;

    @Override
    public String toString() {

        return "customerId=" + customerId + ", " + "productId=" + productId + ", " + "quantity=" + quantity +";";
    }
}
