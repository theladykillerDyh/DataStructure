package com.example.demo.dyh.main;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		PersonNode personNode1 = new PersonNode(1, 1, "张三", null);
		PersonNode personNode2 = new PersonNode(1, 2, "李四", null);
		PersonNode personNode3 = new PersonNode(1, 3, "王五", null);
		PersonNode personNode4 = new PersonNode(1, 4, "飞起", null);
		PersonNode personNode5 = new PersonNode(1, 5, "流弊", null);
		PersonNode personNode6 = new PersonNode(1, 6, "飞起6", null);
		PersonNode personNode7 = new PersonNode(1, 7, "流弊7", null);
		singleLinkedList.addNodeByOrder(personNode2);
		singleLinkedList.addNodeByOrder(personNode1);
		singleLinkedList.addNodeByOrder(personNode3);
		singleLinkedList.addNodeByOrder(personNode4);
		singleLinkedList.addNodeByOrder(personNode5);
		singleLinkedList.showList();
		singleLinkedList.del(personNode3);
		singleLinkedList.showList();
		PersonNode personNode = new PersonNode(1, 4, "飞起????", null);
		singleLinkedList.update(personNode);
		singleLinkedList.showList();
		System.out.println(singleLinkedList.size());
		singleLinkedList.reverse();
		singleLinkedList.showList();
		System.out.println(singleLinkedList.getNodeByNumFromTheEnd(5));
		singleLinkedList.showReverse();
		SingleLinkedList newsSingleLinkedList=new SingleLinkedList();
		newsSingleLinkedList.addNodeByOrder(personNode6);
		newsSingleLinkedList.addNodeByOrder(personNode7);
		singleLinkedList.addAll(newsSingleLinkedList);
		System.out.println("获取杀死");
		singleLinkedList.showList();
		
	}

}

class SingleLinkedList {
	private PersonNode headNode = new PersonNode(0, 0, null, null);

	public PersonNode getHeadNode() {
		return headNode;
	}

	public void setHeadNode(PersonNode headNode) {
		this.headNode = headNode;
	}

	public boolean isEmpty() {
		return headNode.getNextNode() == null;
	}

	// 无序添加，添加是从headNode起的。
	public void addNode(PersonNode personNode) {
		// 找到链表的最后一个node；
		PersonNode temp = headNode;
		while (true) {
			if (temp.getNextNode() == null) {
				temp.setNextNode(personNode);
				break;
			}
			temp = temp.getNextNode();

		}

	}

	// 默认按照升序排列，添加是从headNode起的。
	public void addNodeByOrder(PersonNode personNode) {
		// 找到链表的最后一个node；
		PersonNode temp = headNode;
		while (true) {
			// temp是初始化的head节点
			if (temp.getNextNode() == null) {
				temp.setNextNode(personNode);
				break;
			}
			// personNode在temp和temp.getNextNode之间或者temp之后为空
			if (temp.getNo() < personNode.getNo()
					&& (temp.getNextNode() == null || temp.getNextNode().getNo() > personNode.getNo())) {
				personNode.setNextNode(temp.getNextNode());
				temp.setNextNode(personNode);
				break;
			}
			// 循环
			temp = temp.getNextNode();

		}

	}

	// 修改列表，按照no更新，默认no唯一
	public void update(PersonNode personNode) {
		PersonNode temp = headNode;
		if (isEmpty()) {
			System.out.println("为空不能修改！");
		}
		while (true) {
			if (temp.getNextNode() == null) {
				break;
			}
			if (temp.getNextNode().getNo() == personNode.getNo()) {
				personNode.setNextNode(temp.getNextNode().getNextNode());
				temp.setNextNode(personNode);
				System.out.println("更新成功");
				// 如果no不唯一，那么此处不能break；
				break;
			}
			temp = temp.getNextNode();
		}
	}

	// 删除列表中的某一个元素，根据唯一标识no删除
	public void del(PersonNode personNode) {
		PersonNode temp = headNode;
		if (isEmpty()) {
			System.out.println("为空不能删除！");
		}
		while (true) {
			if (temp.getNextNode() == null) {
				System.out.println("删除失败，没有找到元素！");
			}
			if (temp.getNextNode().getNo() == personNode.getNo()) {
				temp.setNextNode(temp.getNextNode().getNextNode());
				System.out.println("删除成功！");
				break;
			}
			temp = temp.getNextNode();
		}

	}

	public int size() {
		int size = 0;
		PersonNode temp = headNode;
		while (true) {
			if (temp.getNextNode() == null) {
				break;
			}
			size++;
			temp = temp.getNextNode();
		}
		return size;
	}

	public void getNodeByNo(int no) {
		PersonNode temp = headNode;
		if (isEmpty()) {
			System.out.println("为空不能查找！");
		}
		while (true) {
			if (temp.getNextNode() == null) {
				System.out.println("查找失败，没有找到元素！");
			}
			if (temp.getNextNode().getNo() == no) {
				System.out.println(temp);
			}
		}
	}

	public void showList() {
		PersonNode temp = headNode.getNextNode();
		if (isEmpty()) {
			System.out.println("链表为空！");
			return;
		}
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.getNextNode();
		}
	}
	public void reverse() {
		SingleLinkedList newSingleLinkedList = new SingleLinkedList();
		PersonNode temp=headNode;
		if (temp.getNextNode()==null||temp.getNextNode().getNextNode()==null) {
			return;
		}	
		try {
			//反转
			while(true) {
				PersonNode firstNode=temp.getNextNode();
				PersonNode secondNode=temp.getNextNode().getNextNode();
				if (secondNode==null) {
					
					firstNode.setNextNode(headNode.getNextNode());
					headNode.setNextNode(firstNode);//保存头节点的nestnode
					temp.setNextNode(null);
					break;
				}
				firstNode.setNextNode(secondNode.getNextNode());//保存第二个节点的后一个节点
				secondNode.setNextNode(headNode.getNextNode());//将遍历到的第二个节点放到headnode后面
				headNode.setNextNode(secondNode);//保存头节点的nestnode
				if (firstNode.getNextNode()==null) {
					System.out.println("反转完成，退出");
					break;
				}
				temp=temp.getNextNode();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void reverseNew() {
		PersonNode cur=headNode;
		if (cur.getNextNode()==null||cur.getNextNode().getNextNode()==null) {
			return;
		}	
		
	}
	public PersonNode getNodeByNumFromTheEnd(int num) {
		int size = size();
		int num1=size-num+1;
		if (num1<=0) {
			System.out.printf("倒数第%d不存在\n",num);
			return null;
		}
		int count=0;
		PersonNode resultNode=null;
		PersonNode temp=headNode;
		while(count<num1) {
			resultNode=temp.getNextNode();
			count++;
			temp=temp.getNextNode();
		}
		return resultNode;
	}
	public void showReverse() {
		synchronized (headNode) {
			reverse();
			showList();
			reverse();
		}

	}
	public void addAll(SingleLinkedList singleLinkedList) {
		PersonNode temp=headNode;
		while(true) {
			if (temp.getNextNode()==null) {
				break;
			}
			temp=temp.getNextNode();
		}
		temp.setNextNode(singleLinkedList.headNode.getNextNode());
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
