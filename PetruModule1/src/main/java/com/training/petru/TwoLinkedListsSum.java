package com.training.petru;

import java.math.BigDecimal;

public class TwoLinkedListsSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {

            int increment = 0;
            ListNode l1NextNode = l1 != null ? l1.next : null;
            ListNode l2NextNode = l2 != null ? l2.next : null;

            int l1Value = l1 != null ? l1.val : 0;
            int l2Value = l2 != null ? l2.val : 0;

            int val = l1Value + l2Value;

            if (val >= 10) {
                increment = 1;
            }

            if (l1NextNode != null || l2NextNode != null)

                if (l1NextNode != null) {
                    l1NextNode.val += increment;
                } else if (l2NextNode != null) {
                    l2NextNode.val += increment;
                }

            if (head == null) {
                head = tail = new ListNode(val % 10);
            } else {
                if(head.next == null) {
                    tail = new ListNode(val % 10);
                    head.next = tail;
                } else {
                    tail.next = new ListNode(val % 10);
                    tail = tail.next;
                }
            }

            l1= l1NextNode;
            l2= l2NextNode;

            if(l1 == null && l2 == null && val >= 10){
                tail.next = new ListNode(1);
                tail = tail.next;
            }

        }

        return head;
    }
    public static void main(String[] args) {

        ListNode ex1 = new ListNode();

        ex1.insertNode(9);
        ex1.insertNode(9);
        ex1.insertNode(9);
        ex1.insertNode(9);
//        ex1.insertNode(9);
//        ex1.insertNode(9);
//        ex1.insertNode(9);

        ListNode ex2 = new ListNode();
        ex2.insertNode(9);
        ex2.insertNode(9);
//        ex2.insertNode(9);
//        ex2.insertNode(9);

        ListNode e1 = ex1.head;
        ListNode e2 = ex2.head;
//        while(e2 != null){
////            System.out.println(e2.val);
////            e2 = e2.next;
//        }

        ListNode listNode = addTwoNumbers(e1, e2);


        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
