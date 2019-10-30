package fr.lacombedulionvert;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.channels.AcceptPendingException;

public class AccountTest
{

    @Test
    public void initialize_new_account() {
        //Given
        Account compte = new Account();
        //When
        boolean isOk = compte.checkAllIsFine();
        //Then
        Assertions.assertThat(isOk).isTrue();
    }

    @Test
    @Ignore("WIP")
    public void initialize_account_not_checked() {
        //Given
        Account compte = new Account();
        //When
        boolean isNotOk = compte.checkAllIsFine();
        //Then
        Assertions.assertThat(isNotOk).isFalse();
    }

    @Test
    public void create_transaction_list_1000() {
        Transaction transaction = new Transaction ("2019/04/02", 1000, "Deposit");
        Account compte = new Account();
        compte.add(transaction);

        Assertions.assertThat(compte.getBalance()).isEqualTo(1000);
    }

    @Test
    public void create_transaction_1200() {
        Transaction transaction = new Transaction ("2019/04/02", 1200, "Deposit");
        Account compte = new Account();
        compte.add(transaction);

        Assertions.assertThat(compte.getBalance()).isEqualTo(1200);
    }

    @Test
    public void create_transaction_900() {
        Transaction transaction = new Transaction ("2019/04/02", 900, "Deposit");
        Account compte = new Account();
        compte.add(transaction);

        Assertions.assertThat(compte.getBalance()).isEqualTo(900);
    }
}
