package main.java.com.mitrais.studycase;

import main.java.com.mitrais.studycase.adapter.controller.AtmSimulationController;
import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSourceImpl;
import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.SignIn;

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
        //controller
        AtmSimulationController atmSimulationController = new AtmSimulationController(signInUseCase);
        Scanner in = new Scanner(System.in);
        while (true) {
            isDataValid = true;
            System.out.print("Enter Account Number : ");
            String accountNumber = in.nextLine();
            System.out.print("Enter PIN : ");
            String pin = in.nextLine();
            if (accountNumber.length() != 6) {
                System.out.println("Account Number should have 6 digits length");
                isDataValid = false;
            }
            if (pin.length() != 6) {
                System.out.println("PIN should have 6 digits length");
                isDataValid = false;
            }

            if (isDataValid) {
                Account account = atmSimulationController.signIn(accountNumber, pin);
                if (account != null) {
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Name: " + account.getName());
                    System.out.println("Balance: " + account.getBalance());
                } else {
                    System.out.println("account not found");
                }
            }
        }
    }
}
