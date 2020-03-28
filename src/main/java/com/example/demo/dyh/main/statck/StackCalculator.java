package com.example.demo.dyh.main.statck;

public class StackCalculator {
	// 假设数字为个位数，不用处理多位数
	public static void main(String[] args) {
		String string = "3+3*2-8-7";
		System.out.println("表达式为：" + string);
		char[] arrayChar = string.toCharArray();
		ArrayStack2 numStack = new ArrayStack2(100);
		ArrayStack2 operStack = new ArrayStack2(100);
		// 数据和符号位入栈
		
		//栈是先进后出规则，如果后入得符号位优先级小于已经存在于栈中的符号位，那么出栈的时候先计算优先级小的，和逻辑向反。
		//如果已经入栈的符号优先级大，那么先计算已经存在的数据。（数据栈中pop出两个数据，符号栈pop一个数据计算）
		//注意数据位置，栈顶的数据在符号位后，栈底的数据在符号位前面
		for (int i = 0; i < arrayChar.length; i++) {
			if (!ArrayStack2.isOper(arrayChar[i])) {
				numStack.push(arrayChar[i] - 48);
				continue;
			}

			if (operStack.isEmpty()) {
				operStack.push(arrayChar[i]);
			} else {
				if (ArrayStack2.priority(arrayChar[i]) > ArrayStack2.priority(operStack.peek())) {
					operStack.push(arrayChar[i]);
				} else {
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					numStack.push(ArrayStack2.cal(num1, num2, operStack.pop()));
					operStack.push(arrayChar[i]);
				}
			}

		}
		//出栈计算
		while (!operStack.isEmpty()) {
			int oper = operStack.pop();
			int num1 = numStack.pop();
			int num2 = numStack.pop();
			if (operStack.isEmpty()) {
				System.out.printf("计算结果为：%d\n", ArrayStack2.cal(num1, num2, oper));
				break;
			} else {
				numStack.push(ArrayStack2.cal(num1, num2, oper));
			}
		}
	}

}

// 先创建一个栈,直接使用前面创建好
// 定义一个 ArrayStack2 表示栈, 需要扩展功能
class ArrayStack2 {
	private int maxSize; // 栈的大小
	private int[] stack; // 数组，数组模拟栈，数据就放在该数组
	private int top = -1;// top表示栈顶，初始化为-1

	// 构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	// 增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
	public int peek() {
		return stack[top];
	}

	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈-push
	public void push(int value) {
		// 先判断栈是否满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈-pop, 将栈顶的数据返回
	public int pop() {
		// 先判断栈是否空
		if (isEmpty()) {
			// 抛出异常
			throw new RuntimeException("栈空，没有数据~");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据~~");
			return;
		}
		// 需要从栈顶开始显示数据
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

	// 返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
	// 数字越大，则优先级就越高.
	public static int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 假定目前的表达式只有 +, - , * , /
		}
	}

	// 判断是不是一个运算符
	public static boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	// 计算方法
	public static int cal(int num1, int num2, int oper) {
		System.out.printf("操作数1：%d；操作数2：%d，运算符：%d\n", num1, num2, oper);
		int res = 0; // res 用于存放计算的结果
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// 注意顺序
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

}
