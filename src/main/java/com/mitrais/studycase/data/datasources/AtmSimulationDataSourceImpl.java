package main.java.com.mitrais.studycase.data.datasources;

import main.java.com.mitrais.studycase.data.models.AccountModel;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.exceptions.InsufficientBalanceException;

import java.util.Arrays;
import java.util.List;

public class AtmSimulationDataSourceImpl implements AtmSimulationDataSource {

    private final List<AccountModel> accountList = Arrays.asList(
            new AccountModel("John Doe", "012108", 100, "112233"),
            new AccountModel("Jane Doe", "932012", 30, "112244")
    );

    public AccountModel signIn(String accountNumber, String pin) {
        AccountModel result = accountList
                .stream()
                .filter(acc -> accountNumber.equals(acc.getAccountNumber()) && pin.equals(acc.getPin()))
                .findFirst()
                .orElse(null);
        return result;
    }

    @Override
    public AccountModel withdraw(Account account, int withdrawAmount, boolean isFromOtherWithdrawScreen) {
        AccountModel accountModel = findAccount(account.getAccountNumber());
        if (accountModel != null) {
            if (accountModel.getBalance() < withdrawAmount) {
                String message = "Insufficient balance $";
                if (isFromOtherWithdrawScreen) {
                    message += withdrawAmount;
                } else {
                    message += accountModel.getBalance();
                }
                throw new InsufficientBalanceException(message);
            } else {
                accountModel.setBalance(accountModel.getBalance() - withdrawAmount);
            }
        }
        return accountModel;
    }

    @Override
    public AccountModel findAccount(String accountNumber) {
        return accountList
                .stream()
                .filter(acc -> accountNumber.equals(acc.getAccountNumber()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public AccountModel transferFund(String accountSource, String accountDestination, int transferAmount) {
        AccountModel accountModelSource = findAccount(accountSource);
        AccountModel accountModelDestination = findAccount(accountDestination);
        accountModelSource.setBalance(accountModelSource.getBalance() - transferAmount);
        accountModelDestination.setBalance(accountModelDestination.getBalance() + transferAmount);
        return accountModelSource;
    }
}
