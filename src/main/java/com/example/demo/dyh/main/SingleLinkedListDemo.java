package com.example.demo.dyh.main;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class SingleLinkedList {
		private PersonNode headNode = new PersonNode(0, 0, null, null);

		private boolean isEmpty() {
			return headNode.getNextNode() == null;
		}

		private void addNode(PersonNode personNode) {
			// 找到链表的最后一个node；
			PersonNode temp = headNode.nextNode;
			while (true) {
				if (temp.getNextNode() == null) {
					temp.setNextNode(personNode);
					break;
				}
				temp = temp.getNextNode();

			}

		}
		private void show() {
			PersonNode temp = headNode.nextNode;
			if (temp==null){
				System.out.println("链表为空！");
				return;
			}
			while (true) {
				System.out.println(temp);
				temp = temp.getNextNode();
				if (temp == null) {
					break;
				}

			}
		}
	}

	class PersonNode {
		private int age;
		private long no;
		private String name;
		private String dec;
		private PersonNode nextNode;

		public PersonNode(int age, long no, String name, String dec) {
			this.age = age;
			this.no = no;
			this.name = name;
			this.dec = dec;
		}

		public PersonNode getNextNode() {
			return nextNode;
		}

		public void setNextNode(PersonNode nextNode) {
			this.nextNode = nextNode;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getNo() {
			return no;
		}

		public void setNo(long no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDec() {
			return dec;
		}

		public void setDec(String dec) {
			this.dec = dec;
		}

		@Override
		public String toString() {
			return "PersonNode [age=" + age + ", no=" + no + ", name=" + name + ", dec=" + dec + "]";
		}

	}

}
