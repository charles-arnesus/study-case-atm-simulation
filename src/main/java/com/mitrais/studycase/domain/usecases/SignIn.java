package main.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.repositories.AtmSimulationRepository;

public class SignIn {
    private final AtmSimulationRepository atmSimulationRepository;

    public SignIn(AtmSimulationRepository atmSimulationRepository) {
        this.atmSimulationRepository = atmSimulationRepository;
    }

    public Account signIn(String testAccountNumber, String testPin) {
        return atmSimulationRepository.signIn(testAccountNumber, testPin);
    }
}
