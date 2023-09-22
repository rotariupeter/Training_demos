package com.training.petru;


public class ListNode {

    ListNode head;
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void insertNode(int data) {

        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {

            node.next = head;
            head = node;

        }

    }
}
