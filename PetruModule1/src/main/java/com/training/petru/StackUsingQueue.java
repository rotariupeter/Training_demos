package com.training.petru;

import java.util.Collection;
import java.util.Collections;

public class StackUsingQueue {

        private int size = 0;
        private QueueArray q1 = new QueueArray(10);
        private QueueArray q2= new QueueArray(10);
        public StackUsingQueue(int size) {
            this.size = size;
            q1 = new QueueArray(size);
            q2= new QueueArray(size);
        }
        public int pop(){
            return q1.dequeue();
        }

        public void push(int item){

            q2.enqueue(item);

            while(!q1.isEmpty()){
                q2.enqueue(q1.dequeue());
            }
            q1 = q2;
            q2 = new QueueArray(size);
        }
        public int top(){
            return q1.peekHead();
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue(4);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("pop: " + s.pop()+" pop: "+ s.pop());
        System.out.println("top: " + s.top());

    }

}
