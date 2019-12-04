package com.dopscape.criteria;

import java.util.LinkedHashSet;
import java.util.Set;

public class DoubleDigitModifiedCriteria implements Criteria {

    @Override
    public boolean apply(String input) {
        Set<Integer> repetitions = new LinkedHashSet<>();

        int currentRepetition = 1;
        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                currentRepetition++;
            }
            else {
                repetitions.add(currentRepetition);
                currentRepetition = 1;
            }
        }
        repetitions.add(currentRepetition);

        return repetitions.contains(2);
    }

}
