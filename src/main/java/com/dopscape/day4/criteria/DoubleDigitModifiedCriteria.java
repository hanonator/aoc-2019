package com.dopscape.day4.criteria;

public class DoubleDigitModifiedCriteria implements Criteria {

    @Override
    public boolean apply(String input) {
        for (int i = 0; i < input.toCharArray().length - 1; i++) {

            if (input.charAt(i) == input.charAt(i+1)) {
                char leading = i > 0 ? input.charAt(i - 1) : 0;
                char trailing = (i < input.length() - 2) ? input.charAt(i + 2) : 0;

                if (leading != input.charAt(i) && trailing != input.charAt(i))
                    return true;

            }
        }
        return false;
    }

}
