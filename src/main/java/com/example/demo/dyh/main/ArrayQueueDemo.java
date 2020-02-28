package com.example.demo.dyh.main;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// 初始化内部类
		ArrayQueueDemo.ArrayQueue arrayQueue = new ArrayQueueDemo().new ArrayQueue(3);
		arrayQueue.addQueue(9);
		arrayQueue.addQueue(9);
		arrayQueue.addQueue(10);
		arrayQueue.showWholeQueue();
		System.out.println(arrayQueue.getQueue());
		arrayQueue.showQueue();
	}

	class ArrayQueue {
		private int maxSize;
		private int front;
		private int rear;
		private int[] arr;

		// 初始化数组队列
		public ArrayQueue(int size) {
			maxSize = size;
			//初始化-1表示指向表示指向数组前一个位置。
			front = -1;
			rear = -1;
			arr = new int[maxSize];
		}

		// 判断队列为空
		public boolean isEmpty() {
			if (front == rear) {
				return true;
			}
			return false;
		}

		// 判断队列是否满
		public boolean isFull() {
			if (rear == maxSize - 1) {
				return true;

			}
			return false;
		}

		// 添加队列元素
		public void addQueue(int n) {
			if (isFull()) {
				throw new RuntimeException("队列已满，不可插入！");
			}
			rear++;
			arr[rear] = n;
		}

		// 获取队列元素
		public int getQueue() {
			if (isEmpty()) {
				throw new RuntimeException("队列为空，不能取出！");
			}
			front++;
			return arr[front];
		}

		// 显示完整队列
		public void showWholeQueue() {
			if (isEmpty()) {
				throw new RuntimeException("队列为空，不能展示！");
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("arr[%d]=%d\n", i, arr[i]);
			}
		}

		// 显示当前队列
		public void showQueue() {
			if (isEmpty()) {
				throw new RuntimeException("队列为空，不能展示！");
			}
			for (int i = front + 1; i < rear + 1; i++) {
				System.out.printf("arr[%d]=%d\n", i, arr[i]);
			}
		}
	}

}
