package com.example.demo.dyh.main.statck;

public class AarrayStackDemo {

	public static void main(String[] args) {
		AarrayStack arrayStack= new AarrayStack(100);
		arrayStack.show();
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.push(199);
		arrayStack.show();
		arrayStack.pop();
		arrayStack.show();
	}

	

}
class AarrayStack {
	private int maxSize;
	private int top = -1;
	private int[] stack;

	public AarrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push( int value) {
		if (isFull()) {
			throw new RuntimeException("栈满，无法加入");
		}
		top++;
		stack[top]=value;
	}
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，无法取出"); 
		}
		int value=stack[top];
		top--;
		return value;
	}
	public void show() {
		System.out.println("栈为");
		for (int i = top; i >=0; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int[] getStack() {
		return stack;
	}

	public void setStack(int[] stack) {
		this.stack = stack;
	}
	
}
