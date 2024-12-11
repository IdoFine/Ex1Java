package code;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        //add your code here

        if (num == null || num.isEmpty()) {
            return ans;
        }

        int bIndex = num.lastIndexOf('b');
        int base = 10;

        String numberPart = num;
        if (bIndex != -1) {

            if (bIndex == 0 || bIndex == num.length() - 1) {
                return ans;
            }
            numberPart = num.substring(0, bIndex);
            String basePart = num.substring(bIndex + 1);


            if (basePart.length() != 1) {
                return ans;
            }
            char baseChar = basePart.charAt(0);
            if (Character.isDigit(baseChar)) {

                int digitBase = baseChar - '0';
                if (digitBase < 2 || digitBase > 9) {
                    return ans;
                }
                base = digitBase;
            } else if (Character.isLetter(baseChar)) {
                if (!Character.isUpperCase(baseChar)) {
                    return ans;
                }

                baseChar = Character.toUpperCase(baseChar);
                int letterBase = 10 + (baseChar - 'A');
                if (letterBase < 10 || letterBase > 16) {
                    return ans;
                }
                base = letterBase;
            } else {
                return ans;
            }
        }


        for (char c : numberPart.toCharArray()) {
            int value;
            if (Character.isDigit(c)) {
                value = c - '0';
            } else if (Character.isLetter(c)) {
                if (!Character.isUpperCase(c)) {
                    return ans;
                }
                value = Character.toUpperCase(c) - 'A' + 10;
            } else {
                return ans;
            }

            if (value >= base) {
                return ans;
            }
        }

        try {
            ans = Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            return -1;
        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        // add your code here
        if (number2Int(a) == -1) {
            return false;
        }


        ////////////////////
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        // add your code here
        if (num < 0 || base < 2 || base > 16) {
            return ans;
        }
        if (num == 0) {

            if (base == 10) {
                return "0";
            } else {
                return "0b" + baseChar(base);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            if (remainder < 10) {
                sb.append((char) ('0' + remainder));
            } else {
                sb.append((char) ('A' + (remainder - 10)));
            }
            num /= base;
        }
        ans = sb.reverse().toString();


        if (base == 10) {
            return ans;
        } else {

            return ans + "b" + baseChar(base);
        }
    }


    private static char baseChar(int base) {
        if (base <= 9) {
            return (char) ('0' + base);
        } else {
            return (char) ('A' + (base - 10));
        }
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        if (isNumber(n1) == false || isNumber(n2) == false) {
            ans = false;
            return ans;
        }
        if (number2Int(n1) != number2Int(n2)) {
            ans = false;
            return ans;
        }


        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here
        int maxValue = -1;
        for (int i = 0; i < arr.length; i++) {
            String current = arr[i];
            if (current != null && isNumber(current)) {
                int value = number2Int(current);
                if (value > maxValue) {
                    maxValue = value;
                    ans = i;
                }
            }

        }
        ////////////////////
        return ans;

    }
}