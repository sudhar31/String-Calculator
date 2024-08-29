package com.example.stringcalculator;

public class StringCalculator {


    // Add a numbers from a string
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0; // Return 0 for an empty string
        }

        String delimiter = ",|\n"; // Default delimiters for comma and newline
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            delimiter = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1); // Handle for the custom delimiter
        }

        String[] parts = numbers.split(delimiter); // Spliting the  numbers by delimiter
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String part : parts) {
            int number = Integer.parseInt(part);
            if (number < 0) {
                if (negatives.length() > 0) {
                    negatives.append(",");
                }
                negatives.append(number); // Collecting a  negative numbers
            } else {
                sum += number; // Add positive numbers
            }
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }
}
