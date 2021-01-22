package main.java.com.mitrais.studycase.data.datasources;

import main.java.com.mitrais.studycase.data.models.AccountModel;
import main.java.com.mitrais.studycase.domain.entities.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtmSimulationDataSourceImpl implements AtmSimulationDataSource {

    private final List<AccountModel> accountList = Arrays.asList(
            new AccountModel("John Doe", "012108", "$100", "112233"),
            new AccountModel("Jane Doe", "932012", "$30", "112244")
    );

    public AccountModel signIn(String accountNumber, String pin) {
        AccountModel result = accountList
                .stream()
                .filter(acc -> accountNumber.equals(acc.getAccountNumber()) && pin.equals(acc.getPin()))
                .findFirst()
                .orElse(null);
        return result;
    }
}
