package main.java.com.mitrais.studycase.domain.repositories;

import main.java.com.mitrais.studycase.domain.entities.Account;

public interface AtmSimulationRepository {
    Account signIn(String testAccountNumber, String testPin);

    Account withdraw(Account account, int withdrawAmount, boolean isFromOtherWithdrawScreen);

    Account findAccount(String accountNumber);

    Account transferFund(String accountSource, String accountDestination, int transferAmount);
}
