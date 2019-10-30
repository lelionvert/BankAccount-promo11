package fr.lacombe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    private Account account;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        account = Account.createAccount();
    }

    @Test
    void account_creation() {
        assertThat(account.isNew()).isTrue();
    }

    @Test
    void make_deposit_transaction_in_account() {
        // When
        account.deposit(1000, "2019-04-01");

        // Then
        transaction = Transaction.aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(1000)
                .withDate("2019-04-01")
                .build();
        assertThat(account.contains(transaction)).isTrue();
    }

    @Test
    void make_withdrawal_transaction_in_account() {
        // When
        account.withdraw(100, "2019-04-02");

        // Then
        transaction = Transaction.aTransaction()
                .withOperation(Operation.WITHDRAWAL)
                .withAmount(100)
                .withDate("2019-04-02")
                .build();
        assertThat(account.contains(transaction)).isTrue();
    }
}
