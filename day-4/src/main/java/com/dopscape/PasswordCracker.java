package com.dopscape;

import com.dopscape.criteria.DoubleDigitCriteria;
import com.dopscape.criteria.DoubleDigitModifiedCriteria;
import com.dopscape.criteria.NonDecreasingCriteria;

import java.util.LinkedHashSet;
import java.util.Set;

public class PasswordCracker {

    private static final int LOWER_BOUNDS = 136818;
    private static final int HIGHER_BOUNDS = 685979;

    public static void main(String[] args) {
        PasswordVerifier verifier = new PasswordVerifier(Set.of(
                new DoubleDigitCriteria(), new NonDecreasingCriteria()
        ));

        Set<Integer> matches = new LinkedHashSet<>();
        for (int i = LOWER_BOUNDS; i <= HIGHER_BOUNDS; i++) {
            if (verifier.verify(String.valueOf(i))) {
                matches.add(i);
            }
        }
        System.out.println("Total possibilities: " + matches.size());

        // part 2
        verifier = new PasswordVerifier(Set.of(
                new DoubleDigitModifiedCriteria(), new NonDecreasingCriteria()
        ));

        matches = new LinkedHashSet<>();
        for (int i = LOWER_BOUNDS; i <= HIGHER_BOUNDS; i++) {
            if (verifier.verify(String.valueOf(i))) {
                matches.add(i);
            }
        }
        System.out.println("Total possibilities: " + matches.size());
    }

}
