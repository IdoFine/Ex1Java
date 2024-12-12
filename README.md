Ido Fine- 214308694

This project implements a basic number formatting converter and calculator capable of working with strings in bases 2 to 16. It includes functions to validate,
convert, and operate on numbers, alongside an interactive main program (Ex1Main) for user interaction,
and a test program(Ex1Test) that makes shure the program works ,along with the outliers.
Functions in Ex1-
number2Int(String num): Converts a string-formatted number to its decimal representation (returns -1 if invalid).
Example: "101b2" → 5.

isNumber(String a): Checks if a string is in a valid number format.
Example: "101b2" → true, "123b" → false.

int2Number(int num, int base): Converts an integer to a string representation in the specified base.
Example: 5 in base 2 → "101b2".

equals(String n1, String n2): Compares two string-formatted numbers for equality, regardless of base.
Example: "101b2" and "5b10" → true.

maxIndex(String[] arr): Finds the index of the largest number in an array of string-formatted numbers.
Example: ["101b2", "110b2", "EFbG"] → 2.
The Ex1Main class provides a simple interactive console program for testing:

Input: Users enter two string-formatted numbers and a base (2–16).
Operations:
Validates the inputs.
Converts numbers to decimal.
Performs addition and multiplication.
Converts results back to the specified base.
Determines the largest value among inputs and results.
Quit Option: Enter "quit" at any prompt to exit the program.
