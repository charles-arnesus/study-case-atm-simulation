package main.java.com.mitrais.studycase.adapter.controllers;

import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.SignIn;

public class AtmSimulationController {
    private final SignIn signInUseCase;

    public AtmSimulationController(SignIn signInUseCase) {
        this.signInUseCase = signInUseCase;
    }

    public Account signIn(String accountNumber, String pin) {
        return signInUseCase.signIn(accountNumber, pin);
    }
}
