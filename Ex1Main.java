package code;
import static code.Ex1.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;



/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                // add your code here
                System.out.println("num1= " + num1 + " is number: " + isNumber(num1) + ", value: " + number2Int(num1));
                if (isNumber(num1) == false) {
                    System.out.println("ERR: num1 is in the wrong format!(" + num1 + ")");
                    continue;
                }
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if (!num2.equals("quit")) {
                    System.out.println("num2= " + num2 + " is number: " + isNumber(num2) + ", value: " + number2Int(num2));
                    if (isNumber(num2) == false) {
                        System.out.println("ERR: num2 is in the wrong format!(" + num2 + ")");
                        continue;
                    }
                    System.out.println("Enter a base for output: (a number [2,16]");
                    int base = sc.nextInt();
                    int n1 = number2Int(num1);
                    int n2 = number2Int(num2);
                    int sol1 = n1 + n2;
                    int sol2 = n1 * n2;
                    System.out.println(num1 + "+" + num2 + "=" + int2Number(sol1, base));
                    System.out.println(num1 + "*" + num2 + "=" + int2Number(sol2, base));
                    String[] max = {num1, num2, int2Number(sol1, base), int2Number(sol2, base)};
                    int maxIdx = maxIndex(max);
                    System.out.println("Max number over " + java.util.Arrays.toString(max) + " is: " + max[maxIdx]);
                }

                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
