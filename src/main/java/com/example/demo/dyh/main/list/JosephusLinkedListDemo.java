package com.example.demo.dyh.main.list;

public class JosephusLinkedListDemo {

	public static void main(String[] args) {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node6=new Node(6);
		Node node7=new Node(7);
		Node node8=new Node(8);
		JosephusLinkedList JosephusLinkedList=new JosephusLinkedList();
		JosephusLinkedList.add(node1);
		JosephusLinkedList.add(node2);
		JosephusLinkedList.add(node3);
		JosephusLinkedList.add(node4);
		JosephusLinkedList.add(node5);
		JosephusLinkedList.add(node6);
		JosephusLinkedList.add(node7);
		JosephusLinkedList.add(node8);
		System.out.println("--当前环形链表为--");
		JosephusLinkedList.show();
		JosephusLinkedList.getOut(2, 3);

	}
	

}
class JosephusLinkedList{
	//无头结点处理，也可以有头节点；
	private Node firstNode;
	public Node getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}
	public void add(Node node) {
		if (firstNode==null) {
			this.firstNode=node;
			node.setNext(firstNode);
		}
		//找到最后一个节点
		Node lastNode=firstNode;
		while (lastNode.getNext()!=firstNode) {
			lastNode=lastNode.getNext();
		}
		//node加入环形链表
		lastNode.setNext(node);
		node.setNext(firstNode);	
	}
	public void show() {
		if (firstNode==null) {
			System.out.println("节点为空，无法展示！");
			return;
		}
		Node cur=firstNode;
		while (true) {
			System.out.println("节点为："+cur);
			if (cur.getNext()==firstNode) {
				break;
			}
			cur=cur.getNext();
		}
	}
	//从第k个人开始，数m个人，那个人出圈。数数第一个为自己，暨向前移动k-1和m-1个位置（Josephus问题）
	public void getOut(int k,int m) {
		if (firstNode==null) {
			System.out.println("当前环形链表为空，无法移除");
			return;
		}
		if (k<1||m<1) {
			System.out.println("移动参数非法，无法移动");
			return;
		}
		//获取到前一个节点
		Node lastNode=firstNode;
		while (lastNode.getNext()!=firstNode) {
			lastNode=lastNode.getNext();
		}
		//找到第k个人
		for (int i = 0; i < k-1; i++) {
			lastNode=lastNode.getNext();
		}
		while (lastNode!=lastNode.getNext()) {
			for (int j = 0; j < m-1; j++) {
				lastNode=lastNode.getNext();
			}
			Node temp=lastNode.getNext();
			lastNode.setNext(lastNode.getNext().getNext());
			//丢出的节点不指向还，完全无关
			temp.setNext(null);
			System.out.println(temp);
			//更新最初节点
			firstNode=lastNode.getNext();
		}
		System.out.println(lastNode);
	}
}
class Node{
	private int no;
	private Node next;
	public Node(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + "]";
	}
	
}
