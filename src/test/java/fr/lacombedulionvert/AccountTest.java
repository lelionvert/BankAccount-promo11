package fr.lacombedulionvert;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
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
}
