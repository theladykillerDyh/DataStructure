package com.example.demo.dyh.main.util;

import java.math.BigDecimal;

public class CaculateUtils {
    public static BigDecimal baseCaculate(BigDecimal num1, BigDecimal num2, String operator) {
        if (operator.equals("+")) {
            return num1.add(num2);
        } else if (operator.equals("-")) {
            return num1.subtract(num2);
        } else if (operator.equals("*")) {
            return num1.multiply(num2);
        } else {
            return num1.divide(num2);
        }
    }

    public static boolean judageNum(String Str) {
        if (Str.matches("[0-9]+\\.?[0-9]*")) {
            return true;
        }
        return false;

    }

    public static int operateLevel(String operateStr) {
        switch (operateStr) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "(":
                return 10;
            case ")":
                return 10;
            default:
                return 0;

        }

    }
}
