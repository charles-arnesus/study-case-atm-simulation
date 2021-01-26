package main.java.com.mitrais.studycase;

import main.java.com.mitrais.studycase.adapter.controllers.AtmSimulationController;
import main.java.com.mitrais.studycase.adapter.screens.TransactionScreen;
import main.java.com.mitrais.studycase.common.constants.Constants;
import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSourceImpl;
import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.FindAccount;
import main.java.com.mitrais.studycase.domain.usecases.SignIn;
import main.java.com.mitrais.studycase.domain.usecases.TransferFund;
import main.java.com.mitrais.studycase.domain.usecases.Withdraw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isDataValid;
        //data source
        AtmSimulationDataSourceImpl atmSimulationDataSource = new AtmSimulationDataSourceImpl();
        //repository
        AtmSimulationRepositoryImpl atmSimulationRepository = new AtmSimulationRepositoryImpl(atmSimulationDataSource);
        //use case
        SignIn signInUseCase = new SignIn(atmSimulationRepository);
        Withdraw withdrawUseCase = new Withdraw(atmSimulationRepository);
        FindAccount findAccountUseCase = new FindAccount(atmSimulationRepository);
        TransferFund transferFundUseCase = new TransferFund(atmSimulationRepository);
        //controller
        AtmSimulationController atmSimulationController = new AtmSimulationController(signInUseCase,
                withdrawUseCase,
                findAccountUseCase,
                transferFundUseCase);
        Scanner in = new Scanner(System.in);
        while (true) {
            isDataValid = true;
            System.out.print("Enter Account Number : ");
            String accountNumber = in.nextLine();
            System.out.print("Enter PIN : ");
            String pin = in.nextLine();
            if (!accountNumber.matches(Constants.REGEX)) {
                System.out.println("Account Number should only contains numbers");
                isDataValid = false;
            }
            if (accountNumber.length() != 6) {
                System.out.println("Account Number should have 6 digits length");
                isDataValid = false;
            }
            if (!pin.matches(Constants.REGEX)) {
                System.out.println("PIN should only contains number");
                isDataValid = false;
            }
            if (pin.length() != 6) {
                System.out.println("PIN should have 6 digits length");
                isDataValid = false;
            }

            if (isDataValid) {
                Account account = atmSimulationController.signIn(accountNumber, pin);
                if (account != null) {
                    TransactionScreen.run(account, atmSimulationController);
                } else {
                    System.out.println("Invalid Account Number/PIN");
                }
            }
        }
    }
}
