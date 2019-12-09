package com.dopscape.day4.criteria;

public class NonDecreasingCriteria implements Criteria {

    @Override
    public boolean apply(String input) {
        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            if (input.charAt(i + 1) < input.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
