package com.training.petru;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
public class QueueArray {
    private int maxSize;
    private int queueArray[];
    private int head;
    private int rear;
    private int numOfItems;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.head = 0;
        this.rear = -1;
        this.numOfItems = 0;
    }

    public int peekHead(){
        return queueArray[head];
    }
    public int peekRear(){
        return queueArray[rear];
    }
    public boolean isFull(){
        return numOfItems == maxSize;
    }
    public boolean isEmpty(){
        return numOfItems == 0;
    }

    public void enqueue(int item){
        if(isFull()){
            System.out.println("Cannot add as the queue is full. ");
        } else {
            this.numOfItems++;
            if(this.head > 0 && (rear == maxSize-1 || rear < head)){
                if(rear == maxSize-1){
                    rear = 0;
                } else {
                    rear +=1;
                }
                this.queueArray[rear] = item;
            } else {

                this.rear = numOfItems - 1;
                this.queueArray[rear] = item;
            }
            System.out.println("een : "+ peekRear());

        }

    }

    public int dequeue(){

        int result = -1;
        if(isEmpty()){
            System.out.println("Cannot dequeue as the list is empty");
        } else {
            result = queueArray[head];
            this.numOfItems--;
            if(head == maxSize-1) {
                head = 0;
            } else {
                this.head++;
            }
            System.out.println("deq : " + peekHead());
        }

        return result;
    }
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(4);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.dequeue());
        queue.enqueue(50);
        System.out.println(queue.dequeue());
        queue.enqueue(60);
        System.out.println(queue.dequeue());
        queue.enqueue(70);
        System.out.println(queue.dequeue());
        queue.enqueue(80);
//        queue.dequeue();
//        queue.enqueue(90);
//
//        queue.enqueue(900);

        //System.out.println("head "+queue.peekHead());
        System.out.println("final head: ");
        Arrays.stream(queue.getQueueArray()).forEach(i ->System.out.print(" "+i));
    }
}
