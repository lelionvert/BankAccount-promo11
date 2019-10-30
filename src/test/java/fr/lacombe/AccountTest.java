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

    @Test
    void print_statement_multiple_deposits() {
        // When
        account.deposit(1000, transactionDate);
        account.deposit(100, transactionDate.plusDays(1));
        account.deposit(200, transactionDate.plusDays(4));

        // Then
        String expectedPrint = "DATE \t | AMOUNT \t | BALANCE \n" +
                "2019-04-01\t | 1000 \t | 1000\n" +
                "2019-04-02\t | 100 \t | 1100\n" +
                "2019-04-05\t | 200 \t | 1300\n";

        assertThat(account.printStatement()).isEqualTo(expectedPrint);
    }
}
