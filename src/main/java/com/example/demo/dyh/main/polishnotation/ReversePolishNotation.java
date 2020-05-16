package com.example.demo.dyh.main.polishnotation;

import com.example.demo.dyh.main.util.CaculateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//模拟正整数

/**
 *
 */
public class ReversePolishNotation {
    /**
     * @param args
     */
    private static Logger logger = LoggerFactory.getLogger(ReversePolishNotation.class);

    public static void main(String[] args) {
        String reversePolishNotationString = "12 13 + 55 -";
        ArrayList<String> numList = getArr(reversePolishNotationString);
        System.out.println(caculate(numList));
        Stack<Object> stack = new Stack<>();
        String  expression="23 * ( 44 - 32 ) + 99 / 5";
        ArrayList<String> nums=toReversePolishNotation(expression);
        System.out.println(caculate(nums));
    }

    private static ArrayList<String> getArr(String Str) {
        String[] reversePolishNotationArr = Str.split(" ");
        ArrayList<String> reversePolishNotationList = new ArrayList<String>();
        for (int i = 0; i < reversePolishNotationArr.length; i++) {
            reversePolishNotationList.add(reversePolishNotationArr[i]);
        }
        return reversePolishNotationList;
    }

    /**
     * @param numArr
     * @return
     */
    private static BigDecimal caculate(ArrayList<String> numArr) {
        Stack<Object> reversePolishNotationStack = new Stack<Object>();
        for (String num : numArr) {
            if (CaculateUtils.judageNum(num)) {
                reversePolishNotationStack.push(new BigDecimal(num));
            } else {
                BigDecimal num2 = (BigDecimal) reversePolishNotationStack.pop();
                BigDecimal num1 = (BigDecimal) reversePolishNotationStack.pop();
                BigDecimal result = CaculateUtils.baseCaculate(num1, num2, num);
                reversePolishNotationStack.push(result);
            }
        }
        return (BigDecimal) reversePolishNotationStack.pop();
    }

    private static ArrayList<String> toReversePolishNotation(String Str) {
        List<String> items = getArr(Str);
        Stack<Object> operationStack = new Stack<>();
        Stack<Object> numStack = new Stack<>();
        for (String item : items) {
            if (CaculateUtils.judageNum(item)) {
                numStack.push(item);
                System.out.println("numStack push "+item);
            } else {
                if (operationStack.isEmpty() || (CaculateUtils.operateLevel((String) operationStack.pop()) < CaculateUtils.operateLevel(item)) || item.equals("(")) {
                    operationStack.push(item);
                    System.out.println("operationStack push "+item);
                } else if (item.equals(")")) {
                    while (true) {
                        if (operationStack.peek().equals("(")) {
                            operationStack.pop();
                            System.out.println("operationStack pop "+item);
                            break;
                        } else {
                            numStack.push(operationStack.pop());
                            System.out.println("operationStack pop "+item);
                            System.out.println("numStack push "+item);
                        }
                    }
                } else {
                    numStack.push(item);
                    System.out.println("numStack push "+item);
                }
            }
        }
        ArrayList<String> numList = new ArrayList<>();
        for (Object item : numStack) {
            numList.add((String) item);
        }
        return numList;

    }

}
