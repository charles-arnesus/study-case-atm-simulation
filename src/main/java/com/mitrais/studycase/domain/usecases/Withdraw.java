package main.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.repositories.AtmSimulationRepository;

public class Withdraw {
    private final AtmSimulationRepository atmSimulationRepository;

    public Withdraw(AtmSimulationRepository atmSimulationRepository) {
        this.atmSimulationRepository = atmSimulationRepository;
    }

    public Account withdraw(Account account, int withdrawAmount, boolean isFromOtherWithdrawScreen) {
        return atmSimulationRepository.withdraw(account, withdrawAmount, isFromOtherWithdrawScreen);
    }
}
