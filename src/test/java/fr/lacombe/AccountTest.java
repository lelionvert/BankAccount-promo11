package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountTest {
    @Test
    void account_creation() {
        // Given
        Account account = new Account();

        // When
        boolean empty = account.getListTransaction().isEmpty();

        // Then
        Assertions.assertThat(empty).isTrue();
    }
}
