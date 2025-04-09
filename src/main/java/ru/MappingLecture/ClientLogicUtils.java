package ru.MappingLecture;

import java.math.BigDecimal;
import java.util.List;

public class ClientLogicUtils {


    private final static BigDecimal BIG_AMOUNT_FROM= new BigDecimal(500000);

    public  static List<ShortInfo>  findClintWithBigSums (List<ClientBankAccount> clientBankAccounts){
        return clientBankAccounts.stream()
                .filter(clientBankAccount -> BIG_AMOUNT_FROM.compareTo(clientBankAccount.getAmount()) < 0)
                .map(BankAccountInfoMapper.INSTANCE::toShortInfo)
                .toList();

    }
}
