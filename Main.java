//to-do: exceptions

import java.util.Scanner;

public class Main {
    private static java.lang.Exception Exception;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(calc(in.nextLine()));
            }
            catch (Exception ex) {
                System.out.println("throws Exception");
                break;
            }
        }
    }

    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");
        String numeralSystem = checkIfArabic(input);

        if (numeralSystem.equals("arabic"))
            return calcArabic(str);
        else if (numeralSystem.equals("roman"))
            return calcRoman(str);
        else
            throw new Exception();
    }

    static String calcArabic(String[] str) throws Exception {
        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[2]);
        String operator = str[1];

        if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
            throw new Exception();
        }

        if (operator.equals("+"))
            return Integer.toString(num1 + num2);
        else if (operator.equals("-"))
            return Integer.toString(num1 - num2);
        else if (operator.equals("*"))
            return Integer.toString(num1 * num2);
        else if (operator.equals("/"))
            return Integer.toString(num1 / num2);

        else throw new Exception();
    }

    static String calcRoman(String[] str) throws Exception {
        RomanNumerals rn1 = RomanNumerals.valueOf(str[0]);
        RomanNumerals rn2 = RomanNumerals.valueOf(str[2]);
        int num1 = rn1.getValue(), num2 = rn2.getValue();

        if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1)
            throw new Exception();

        int intResult = 0;
        String operator = str[1];
        if (operator.equals("+"))
            intResult = (num1 + num2);
        else if (operator.equals("-"))
            intResult = (num1 - num2);
        else if (operator.equals("*"))
            intResult = (num1 * num2);
        else if (operator.equals("/"))
            intResult = (num1 / num2);

        if (intResult < 1)
            throw new Exception();
        String romResult = "";
        for (RomanNumerals RN: RomanNumerals.values()) {
            if (intResult == RN.value)
                romResult = RN.name();
        }

        return romResult;
    }

    static String checkIfArabic(String input) throws Exception {
        String[] str = input.split(" ");
        int n1 = 0, n2 = 0;
        try {
            try {
                n1 = Integer.parseInt(str[0]);
                n2 = Integer.parseInt(str[2]);
            } catch (Exception exception) {
                return checkIfRoman(input);
            }
        }
        catch (Exception exception) {
            throw new Exception();
        }
        return "arabic";
    }

    static String checkIfRoman(String input) throws Exception {
        String[] str = input.split(" ");
        if (str[0].equals("I") || str[0].equals("II") || str[0].equals("III") || str[0].equals("IV") || str[0].equals("V")
                || str[0].equals("VI") || str[0].equals("VII") || str[0].equals("VIII") || str[0].equals("IX") || str[0].equals("X") || str[0].equals("C")) {
            if (str[2].equals("I") || str[2].equals("III") || str[2].equals("II") || str[2].equals("IV") || str[2].equals("V")
                    || str[2].equals("VI") || str[2].equals("VII") || str[2].equals("VIII") || str[2].equals("IX") || str[2].equals("X") || str[0].equals("C"))
                return "roman";
        }
        else throw new Exception();
        return "";
    }

    enum RomanNumerals {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20),
        XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26), XXVII(27), XXVIII(28), XXIX(29), XXX(30),
        XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45), XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
        LI(51), LII(52), LIII(53), LIV(54), LV(55), LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
        LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65), LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
        LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75), LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
        LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85), LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
        XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95), XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100);
        private int value;
        RomanNumerals(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}