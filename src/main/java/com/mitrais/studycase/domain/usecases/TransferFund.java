package main.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.repositories.AtmSimulationRepository;

public class TransferFund {
    final private AtmSimulationRepository atmSimulationRepository;

    public TransferFund(AtmSimulationRepository atmSimulationRepository) {
        this.atmSimulationRepository = atmSimulationRepository;
    }

    public Account transferFund(String accountSource, String accountDestination, int transferAmount) {
        return atmSimulationRepository.transferFund(accountSource, accountDestination, transferAmount);
    }
}
