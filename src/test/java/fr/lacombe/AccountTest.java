package fr.lacombe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = Account.createAccount();
    }

    @Test
    void account_creation() {
        assertThat(account.getListTransaction()).isEmpty();
    }

    @Test
    void first_deposit() {
        // When
        account.deposit(1000, "2019-04-01");

        // Then
        Transaction transaction = new Transaction(Operation.DEPOSIT, 1000, "2019-04-01");
        assertThat(account.getListTransaction()).containsExactly(transaction);
    }
}
