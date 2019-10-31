package fr.lacombedulionvert;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {
    @Test
    public void initialize_new_account() {
        //Given
        Account compte = new Account();
        //When
        boolean isOk = compte.checkAllIsFine();
        //Then

        assertThat(isOk).isTrue();
    }

    @Test
    public void initialize_account_not_checked() {
        //Given
        Account compte = new Account();
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction = Transaction.initialize().withDate("2019/04/02").withAmount(900).withType("Deposit").build();
        transactions.add(transaction);
        compte.deposit(transaction);
        //When
        boolean isNotOk = compte.checkAllIsFine();
        //Then
        assertThat(isNotOk).isFalse();
    }

    private Object[] parametersForCreate_transaction() {
        return new Object[][]{
                {Transaction.initialize().withDate("2019/04/02").withAmount(900).withType("Deposit").build(), 900},
                {Transaction.initialize().withDate("2019/04/02").withAmount(1000).withType("Deposit").build(), 1000},
                {Transaction.initialize().withDate("2019/04/02").withAmount(1200).withType("Deposit").build(), 1200}
        };
    }

    @Test
    @Parameters
    public void create_transaction(final Transaction transaction, final int expected) {
        Account compte = new Account();

        compte.deposit(transaction);

        assertThat(compte.getBalance()).isEqualTo(expected);
    }

    private Object[] parametersForCreate_transaction_list() {
        return new Object[][]{
                {900, 2700},
                {1000, 3000},
                {1200, 3600}
        };
    }

    @Test
    @Parameters
    public void create_transaction_list(final int amount, final int expected) {
        Account compte = new Account();
        ArrayList<Transaction> transactions = new ArrayList<>();

        compte.deposit(amount);
        compte.deposit(amount);
        compte.deposit(amount);

        assertThat(compte.getBalance()).isEqualTo(expected);
    }

}
