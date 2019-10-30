package fr.lacombe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    private Account account;
    private Transaction transaction;
    private LocalDate transactionDate;

    @BeforeEach
    void setUp() {
        account = Account.createAccount();
        transactionDate = LocalDate.of(2019, 4, 1);
    }

    @Test
    void account_creation() {
        assertThat(account.isNew()).isTrue();
    }

    @Test
    void make_deposit_transaction_in_account() {
        // When
        account.deposit(1000, transactionDate);

        // Then
        transaction = Transaction.aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(1000)
                .withDate(transactionDate)
                .build();
        assertThat(account.contains(transaction)).isTrue();
    }

    @Test
    void make_withdrawal_transaction_in_account() {
        // When
        account.withdraw(100, transactionDate);

        // Then
        transaction = Transaction.aTransaction()
                .withOperation(Operation.WITHDRAWAL)
                .withAmount(100)
                .withDate(transactionDate)
                .build();
        assertThat(account.contains(transaction)).isTrue();
    }
}
