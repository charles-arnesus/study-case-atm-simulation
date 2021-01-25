package main.java.com.mitrais.studycase.data.datasources;

import main.java.com.mitrais.studycase.domain.entities.Account;

public interface AtmSimulationDataSource {
    Account signIn(String accountNumber, String pin);

    Account withdraw(Account account, int withdrawAmount, boolean isFromOtherWithdrawScreen);
}
