package com.dopscape.day1;

import com.dopscape.day1.calculator.RecursiveRocketFuelCalculator;
import com.dopscape.day1.calculator.RocketFuelCalculator;
import com.dopscape.day1.calculator.SimpleRocketFuelCalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ApplicationRocketFuel {

   public static void main(String[] args) throws IOException {
       Set<Integer> input = input();

       System.out.println("simple: " + new SimpleRocketFuelCalculator().aggregate(input));
       System.out.println("recursive: " + new RecursiveRocketFuelCalculator().aggregate(input));
   }

    private static Set<Integer> input() throws IOException {
        Set<Integer> input = new LinkedHashSet<>();
        try (InputStream in = RocketFuelCalculator.class.getClassLoader().getResourceAsStream("day1-input")) {
            if (in == null) {
                throw new FileNotFoundException();
            }
            try (Scanner scanner = new Scanner(in)) {
                while (scanner.hasNextLine()) {
                    input.add(Integer.valueOf(scanner.nextLine()));
                }
            }
        }
        return input;
    }

}
