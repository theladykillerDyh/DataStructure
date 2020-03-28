package com.example.demo.dyh.main.polishnotation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;

import com.example.demo.dyh.main.util.CaculateUtils;


//模拟正整数
public class ReversePolishNotation {

	public static void main(String[] args) {
		String reversePolishNotationString="12 13 + 55 -";
		ArrayList<String> numList=getArr(reversePolishNotationString);
		System.out.println(caculate(numList));
			
	}
	private static ArrayList<String> getArr(String Str) {
		String[] reversePolishNotationArr=Str.split(" ");
		ArrayList<String> reversePolishNotationList=new ArrayList<String>();
		for (int i = 0; i < reversePolishNotationArr.length; i++) {
			reversePolishNotationList.add(reversePolishNotationArr[i]);
		}
		return reversePolishNotationList;
	}
	private static BigDecimal caculate(ArrayList<String> numArr) {
		Stack<Object> reversePolishNotationStack=new Stack<Object>();
		for (String num : numArr) {
			if (CaculateUtils.judageNum(num)) {
				reversePolishNotationStack.push(new BigDecimal(num));
			}else {
				BigDecimal num2=(BigDecimal)reversePolishNotationStack.pop();
				BigDecimal num1=(BigDecimal)reversePolishNotationStack.pop();
				BigDecimal result= CaculateUtils.baseCaculate(num1, num2, num);
				reversePolishNotationStack.push(result);
			}
		}
		return (BigDecimal)reversePolishNotationStack.pop();
	}


}
