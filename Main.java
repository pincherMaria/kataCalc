//to-do: exceptions and roman numerals

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true)
            System.out.println(calc(in.nextLine()));
    }

    public static String calc(String input) {
        String[] str = input.split(" ");

        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[2]);
        String operator = str[1];

        if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
            return "Exception: an operand cannot be greater than 10 and less than 1";
        }

        if (operator.equals("+"))
            return Integer.toString(num1 + num2);
        else if (operator.equals("-"))
            return Integer.toString(num1 - num2);
        else if (operator.equals("*"))
            return Integer.toString(num1 * num2);
        else if (operator.equals("/"))
            return Integer.toString(num1 / num2);
        
        else return "Exception: unknown operator";
    }
}