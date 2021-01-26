package main.java.com.mitrais.studycase.adapter.controllers;

import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.FindAccount;
import main.java.com.mitrais.studycase.domain.usecases.SignIn;
import main.java.com.mitrais.studycase.domain.usecases.TransferFund;
import main.java.com.mitrais.studycase.domain.usecases.Withdraw;

public class AtmSimulationController {
    private final SignIn signInUseCase;
    private final Withdraw withdrawUseCase;
    private final FindAccount findAccountUseCase;
    private final TransferFund transferFundUseCase;

    public AtmSimulationController(SignIn signInUseCase,
                                   Withdraw withdrawUseCase,
                                   FindAccount findAccountUseCase,
                                   TransferFund transferFundUseCase) {
        this.signInUseCase = signInUseCase;
        this.withdrawUseCase = withdrawUseCase;
        this.findAccountUseCase = findAccountUseCase;
        this.transferFundUseCase = transferFundUseCase;
    }

    public Account signIn(String accountNumber, String pin) {
        return signInUseCase.signIn(accountNumber, pin);
    }

    public Account withdraw(int withdrawAmount, Account account, boolean isFromOtherWithdrawScreen) {
        return withdrawUseCase.withdraw(account, withdrawAmount, isFromOtherWithdrawScreen);
    }

    public Account findAccount(String accountNumber) {
        return findAccountUseCase.findAccount(accountNumber);
    }

    public Account transferFund(String accountSource, String accountDestination, int transferAmount) {
        return transferFundUseCase.transferFund(accountSource, accountDestination, transferAmount);
    }
}
