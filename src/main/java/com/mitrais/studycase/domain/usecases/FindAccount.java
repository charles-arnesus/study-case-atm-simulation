package main.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.repositories.AtmSimulationRepository;

public class FindAccount {
    final private AtmSimulationRepository atmSimulationRepository;

    public FindAccount(AtmSimulationRepository atmSimulationRepository) {
        this.atmSimulationRepository = atmSimulationRepository;
    }

    public Account findAccount (String accountNumber) {
        return atmSimulationRepository.findAccount(accountNumber);
    }
}
