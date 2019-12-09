package com.dopscape.day4;

import com.dopscape.day4.criteria.Criteria;

import java.util.Set;

public class PasswordVerifier {

    private final Set<Criteria> criteria;

    public PasswordVerifier(Set<Criteria> criteria) {
        this.criteria = criteria;
    }

    public boolean verify(String input) {
        return criteria.stream().allMatch(criteria -> criteria.apply(input));
    }

}
