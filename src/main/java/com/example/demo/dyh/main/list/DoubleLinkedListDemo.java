package com.example.demo.dyh.main.list;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		Person Person1 = new Person(1, 1, "张三", null);
		Person Person2 = new Person(1, 2, "李四", null);
		Person Person3 = new Person(1, 3, "王五", null);
		Person Person4 = new Person(1, 4, "飞起", null);
		Person Person5 = new Person(1, 5, "流弊", null);
		Person Person11 = new Person(1, 1, "张三1", null);
		Person Person21 = new Person(1, 2, "李四1", null);
		Person Person41 = new Person(1, 4, "飞起1", null);
		doubleLinkedList.add(Person1);
		doubleLinkedList.add(Person2);
		doubleLinkedList.add(Person3);
		doubleLinkedList.add(Person4);
		doubleLinkedList.showList();
		System.out.println("删除展示");
		doubleLinkedList.deleteByPerson(Person5);
		doubleLinkedList.showList();
		System.out.println("删除展示");
		doubleLinkedList.deleteByPerson(Person4);
		doubleLinkedList.showList();
		System.out.println("修改展示");
		doubleLinkedList.update(Person11);
		doubleLinkedList.update(Person21);
		doubleLinkedList.update(Person41);
		doubleLinkedList.showList();
	}

}

class DoubleLinkedList {
	private Person head = new Person(0, 0, null, null);

	public Person getHead() {
		return head;
	}

	public void setHead(Person head) {
		this.head = head;
	}

	public void add(Person person) {
		Person cur = head;
		while (true) {
			if (cur.getNext() == null) {
				cur.setNext(person);
				person.setPre(cur);
				break;
			}
			cur = cur.getNext();
		}

	}

	public void deleteByPerson(Person person) {
		if (person == null) {
			return;
		}
		Person cur = head.getNext();
		while (cur != null) {
			if (cur.getNo() == person.getNo()) {
				cur.getPre().setNext(cur.getNext());
				if (cur.getNext() != null) {
					cur.getNext().setPre(cur.getPre());
				}

				break;
			}
			cur = cur.getNext();
		}

	}

	public void update(Person person) {
		if (person == null) {
			return;
		}
		Person cur = head.getNext();
		while (cur != null) {
			if (cur.getNo() == person.getNo()) {
				cur.getPre().setNext(person);
				person.setPre(cur.getPre());
				if (cur.getNext() != null) {
					cur.getNext().setPre(person);
					person.setNext(cur.getNext());
				}

				break;
			}
			cur = cur.getNext();
		}
	}

	public void showList() {
		Person cur = head.getNext();
		while (cur != null) {
			System.out.println(cur);
			cur = cur.getNext();
		}
	}
}

class Person {
	private int age;
	private long no;
	private String name;
	private String dec;
	private Person next;
	private Person pre;

	public Person(int age, long no, String name, String dec) {
		this.age = age;
		this.no = no;
		this.name = name;
		this.dec = dec;
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

	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}

	public Person getPre() {
		return pre;
	}

	public void setPre(Person pre) {
		this.pre = pre;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", no=" + no + ", name=" + name + "]";
	}

}
