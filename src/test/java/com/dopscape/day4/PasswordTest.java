package com.dopscape.day4;

import com.dopscape.day4.criteria.DoubleDigitCriteria;
import com.dopscape.day4.criteria.DoubleDigitModifiedCriteria;
import com.dopscape.day4.criteria.NonDecreasingCriteria;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {

    @ParameterizedTest
    @MethodSource("providesPasswords")
    public void testPasswordCriteria(String input, boolean output) {
        PasswordVerifier verifier = new PasswordVerifier(Set.of(new DoubleDigitCriteria(),
                new NonDecreasingCriteria()));

        assertThat(verifier.verify(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @MethodSource("providesPasswords2")
    public void testPasswordCriteriaModified(String input, boolean output) {
        PasswordVerifier verifier = new PasswordVerifier(Set.of(new DoubleDigitModifiedCriteria(),
                new NonDecreasingCriteria()));

        assertThat(verifier.verify(input)).isEqualTo(output);
    }

    public static Stream<Arguments> providesPasswords() {
        return Stream.of(
                Arguments.of("111111", true),
                Arguments.of("223450", false),
                Arguments.of("123789", false));
    }

    public static Stream<Arguments> providesPasswords2() {
        return Stream.of(
                Arguments.of("112233", true),
                Arguments.of("123444", false),
                Arguments.of("111122", true));
    }

}
