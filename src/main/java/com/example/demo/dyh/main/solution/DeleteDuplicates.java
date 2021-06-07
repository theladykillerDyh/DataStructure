package com.example.demo.dyh.main.solution;

import com.example.demo.dyh.main.list.ListNode;

public class DeleteDuplicates {

    public static void main(String[] args) {

        int nums=[0,2,4,5,6,1,7,8,9];




        ListNode head=new ListNode(1);
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(1);
        ListNode d=new ListNode(1);
        ListNode e=new ListNode(2);
        ListNode f=new ListNode(1);
        ListNode g=new ListNode(1);
        ListNode h=new ListNode(5);
        head.next=a;a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;f.next=g;g.next=h;
        ListNode.showNode(head);
        ListNode resultNode= deleteDuplicates(head);
        ListNode.showNode(resultNode);

    }

    public static int[] twoSum(int[] nums,int sum){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){

            }
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            int curRepeatNum = 0;
            ListNode difNode = cur;
            // 找到和cur指向的结点值不同的结点
            while (difNode != null && difNode.val == cur.val) {
                curRepeatNum++;
                difNode = difNode.next;
            }

            // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
            if (curRepeatNum > 1) {
                prev.next = difNode;
            }else {
                // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                prev = cur;
            }
            cur = difNode;
        }

        return dummyHead.next;
    }

}
