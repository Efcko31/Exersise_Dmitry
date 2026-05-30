package ru.lectures;

import org.junit.jupiter.api.Test;
import ru.lectures.MappingLecture.ClientBankAccount;
import ru.lectures.MappingLecture.ClientLogicUtils;

import java.math.BigDecimal;
import java.util.List;

public class MappersLectionTest {

    // Мапперу необходимо ЯВНО указывать на переменные!
    private final ClientBankAccount CLIENT1 = new ClientBankAccount("tfth",
            "rgdgd",
            "drgrdg",
            "1256",
            "123456",
            new BigDecimal("1000000.25"),
            "RU");

    private final ClientBankAccount CLIENT2 = new ClientBankAccount("tfth",
            "rgdgd",
            "drgrdg",
            "1256",
            "123456",
            new BigDecimal("5456.25"),
            "RU");

    private final ClientBankAccount CLIENT3 = new ClientBankAccount("tfth",
            "rgdgd",
            "drgrdg",
            "1256",
            "123456",
            new BigDecimal("0.25"),
            "RU");

    private final ClientBankAccount CLIENT4 = new ClientBankAccount("tfth",
            "rgdgd",
            "drgrdg",
            "1256",
            "123456",
            new BigDecimal("5023650.25"),
            "Казахстан");

    List<ClientBankAccount> clientBankAccounts = List.of(CLIENT1, CLIENT2, CLIENT3, CLIENT4);


    @Test
    public void getShortInfoTest() {
        System.out.printf(ClientLogicUtils.findClintWithBigSums(clientBankAccounts).toString());
    }

}
