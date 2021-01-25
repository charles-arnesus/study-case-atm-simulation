package test.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSourceImpl;
import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.exceptions.InsufficientBalanceException;
import main.java.com.mitrais.studycase.domain.usecases.SignIn;
import main.java.com.mitrais.studycase.domain.usecases.Withdraw;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class WithdrawTest {
    private final AtmSimulationDataSourceImpl atmSimulationDataSource = new AtmSimulationDataSourceImpl();
    private final AtmSimulationRepositoryImpl atmSimulationRepository = new AtmSimulationRepositoryImpl(atmSimulationDataSource);
    private final Withdraw useCase = new Withdraw(atmSimulationRepository);

    @Test
    public void testShouldSuccessfullyDeductBalanceFromAccount() {
        final Account testAccount = new Account("John Doe", "012108", 100, "112233");
        final Account testAccountResult = new Account("John Doe", "012108", 90, "112233");
        final int withdrawAmount = 10;
        final Account result = useCase.withdraw(testAccount, withdrawAmount, false);
        assertEquals(testAccountResult, result);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testShouldThrowInsufficientBalanceExceptionWhenBalanceIsLowerThanWithdrawAmount() {
        thrown.expect(InsufficientBalanceException.class);
        thrown.expectMessage("Insufficient balance $100");
        final Account testAccount = new Account("John Doe", "012108", 100, "112233");
        final int withdrawAmount = 160;
        useCase.withdraw(testAccount, withdrawAmount, false);
    }
}
