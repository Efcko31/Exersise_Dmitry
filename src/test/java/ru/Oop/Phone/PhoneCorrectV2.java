package ru.Oop.Phone;

import lombok.*;

@Data //getter + setter
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneCorrectV2 {

    private String number;
    private String model;
    private int weight;

    public PhoneCorrectV2(String number, String model) {
        this.number = number;
        this.model = model;
    }
}
