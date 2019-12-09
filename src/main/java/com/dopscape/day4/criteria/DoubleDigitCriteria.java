package com.dopscape.criteria;

public class DoubleDigitCriteria implements Criteria {

    @Override
    public boolean apply(String input) {
        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            if (input.charAt(i) == input.charAt(i+1))
                return true;
        }
        return false;
    }

}
