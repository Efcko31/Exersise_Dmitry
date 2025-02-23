package ru.Oop.PhoneDirectory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String cityOfResidence;
    private String address;
    private String typeofActivity;
//    private String makeCall = String.format("Начат вызов. %s т.%s%n", firstName, phoneNumber);

}
