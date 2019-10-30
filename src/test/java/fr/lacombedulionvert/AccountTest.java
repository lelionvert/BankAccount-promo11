package fr.lacombedulionvert;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    @Ignore("WIP")
    public void initialize_account_not_checked() {
        //Given
        Account compte = new Account();
        //When
        boolean isNotOk = compte.checkAllIsFine();
        //Then
        assertThat(isNotOk).isFalse();
    }

    private Object[] parametersForCreate_transaction() {
        return new Object[][]{
                {"2019/04/02", 1000, "Deposit", 1000},
                {"2019/04/02", 1200, "Deposit", 1200},
                {"2019/04/02", 900, "Deposit", 900}
        };
    }

    @Test
    @Parameters
    public void create_transaction(final String date, final int amount, final String type, final int expected) {
        Transaction transaction = new Transaction (date, amount, type);
        Account compte = new Account();
        compte.add(transaction);

        assertThat(compte.getBalance()).isEqualTo(expected);
    }

}
