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
        assertThat(account.isNew()).isTrue();
    }

    @Test
    void first_deposit() {
        // When
        account.deposit(1000, "2019-04-01");

        // Then
        Transaction transaction = Transaction.aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(1000)
                .withDate("2019-04-01")
                .build();
        assertThat(account.contains(transaction)).isTrue();
    }
}
