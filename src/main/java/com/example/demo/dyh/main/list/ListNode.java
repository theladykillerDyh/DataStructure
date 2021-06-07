package com.example.demo.dyh.main.list;

import org.springframework.http.StreamingHttpOutputMessage;

public class ListNode {
   public int val;
   public ListNode next;

    public ListNode() {
    }

   public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static void showNode(ListNode listNode){
        System.out.println("begin");
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
        System.out.println("end");
    };

}
