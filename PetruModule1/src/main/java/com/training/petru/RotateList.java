package com.training.petru;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null)
            return null;
        int listSize = listSize(head);

        if(k > listSize)
            k = k%listSize;

        ListNode last = head;
        for (int i = 0; i < k; i++) {
            ListNode previous = last;
            while (last.next != null) {
                previous = last;
                last = last.next;
            }
            last.next = head;
            head = last;
            previous.next = null;
        }
        return last;
    }

    public static int listSize(ListNode listNode){
        int count = 1;
        if(listNode.next != null){
            return count+listSize(listNode.next);
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.insertNode(1);
        listNode.insertNode(2);
        listNode.insertNode(3);
        listNode.insertNode(4);
        listNode.insertNode(5);

        System.out.println(200%350);
        ListNode listNode1 = rotateRight(listNode.head, 2);
    }
}
