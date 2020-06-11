package com.example.demo.dyh.main.polishnotation;

import com.example.demo.dyh.main.util.CaculateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;


//模拟正整数

/**
 *
 */
public class  ReversePolishNotation {
    /**
     * @param args
     */
    private static final Logger logger = LoggerFactory.getLogger(ReversePolishNotation.class);

    public static void main(String[] args) {
        logger.error("逆波兰表达式");
        String reversePolishNotationString = "12 13 + 55 -";
        ArrayList<String> numList = getArr(reversePolishNotationString);
        logger.error("sss:{}", caculate(numList));
        Stack<Object> stack = new Stack<>();
        String expression = "23 * ( 44 - 32 ) + 99 / 5";
        ArrayList<String> nums = toReversePolishNotation(expression);
        logger.error("sss:{}", nums);
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

    /*  1、数字直接入数字栈
        2、左括号直接入符号栈
        3、运算符
        1）如果符号栈为空或者符号栈顶为左括号，直接入栈
        2）如果该运算符优先级大于符号栈顶，那么直接入栈；如果运算符优先级小于符号栈顶，
        4、右括号
        右括号不入符号栈，将符号栈里面的符号加入数字栈，直到符号栈为空或者遇到左括号，最后将左括号丢弃。*/
    private static ArrayList<String> toReversePolishNotation(String Str) {
        List<String> items = getArr(Str);
        Stack<Object> operationStack = new Stack<>();
        Stack<Object> numStack = new Stack<>();
        Boolean bracketFlag = false;
        for (String item : items) {
            if (CaculateUtils.judageNum(item)) {
                numStack.push(item);

            } else {
                delOperation(operationStack, numStack, item);
            }
        }
        while (!operationStack.isEmpty()) {
            numStack.push(operationStack.pop());
        }
        ArrayList<String> list = new ArrayList<>();
        while (!numStack.isEmpty()) {
            list.add((String) numStack.pop());
        }
        Collections.reverse(list);
        return list;

    }

    private static void delOperation(Stack operationStack, Stack numStack, String item) {
        //括号处理
        if (CaculateUtils.isBracket(item)) {
            if (CaculateUtils.isLeftBracket(item)) {
                operationStack.push(item);
            } else if (CaculateUtils.isRightBracket(item)) {
                //移除所有符号到numStack
                while (!CaculateUtils.isBracket((String) operationStack.peek())) {
                    numStack.push(operationStack.pop());
                }
                //移除左括号
                operationStack.pop();
            }
        }
        //运算符处理
        if (CaculateUtils.isOperate(item)) {
            if (operationStack.isEmpty() || CaculateUtils.isLeftBracket((String) operationStack.peek()) || CaculateUtils.operateLevel(item) > CaculateUtils.operateLevel((String) operationStack.peek())) {
                {
                    operationStack.push(item);
                }

            } else {
                do {
                    numStack.push(operationStack.pop());
                } while (!operationStack.isEmpty() && (CaculateUtils.operateLevel(item) < CaculateUtils.operateLevel((String) operationStack.peek())));
                operationStack.push(item);
            }
        }


    }
}


