package com.example.demo.dyh.main.list;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// 初始化内部类
		CircleArrayQueueDemo.CircleArrayQueue arrayQueue = new CircleArrayQueueDemo().new CircleArrayQueue(3);
		arrayQueue.addQueue(9);
		arrayQueue.addQueue(9);
		arrayQueue.addQueue(10);
		System.out.println(arrayQueue.getFront());
		System.out.println(arrayQueue.getRear());
		/*
		 * arrayQueue.showWholeQueue(); System.out.println(arrayQueue.getQueue());
		 * arrayQueue.showQueue();
		 */
	}

	class CircleArrayQueue {
		// 思路：font和rear不清零一直加，求下角标除莫
		private int maxSize;
		private int front;
		private int rear;
		private int[] arr;

		// 初始化数组队列
		public CircleArrayQueue(int size) {
			maxSize = size;
			// 初始化-1表示指向表示指向数组前一个位置。
			front = 0;
			rear = 0;
			arr = new int[maxSize];
		}

		public int getMaxSize() {
			return maxSize;
		}

		public void setMaxSize(int maxSize) {
			this.maxSize = maxSize;
		}

		public int getFront() {
			return front;
		}

		public void setFront(int front) {
			this.front = front;
		}

		public int getRear() {
			return rear;
		}

		public void setRear(int rear) {
			this.rear = rear;
		}

		public int[] getArr() {
			return arr;
		}

		public void setArr(int[] arr) {
			this.arr = arr;
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
			return (rear + 1) % maxSize == front;
		}

		// 添加队列元素
		public void addQueue(int n) {

			if (isFull()) {
				throw new RuntimeException("队列已满，不可插入！");
			}

			arr[rear] = n;
			// 每次加入数据，rear地址加一，当数组满的时候，rear的值%maxSize=0
			rear = (rear + 1) % maxSize;
		}

		// 获取队列元素
		public int getQueue() {
			if (isEmpty()) {
				throw new RuntimeException("队列为空，不能取出！");
			}
			int frontValue = arr[front];
			front = (front + 1) % maxSize;
			return frontValue;
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
			for (int i = front; i < rear; i++) {
				System.out.printf("arr[%d]=%d\n", i, arr[i]);
			}
		}
	}

}
