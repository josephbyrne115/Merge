//Author: Joseph Byrne

import java.util.Scanner;

public class ListQueue implements Queue {

    protected Node head;
    protected Node tail;
    protected int size;

    public ListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int front() {
        if(size == 0) return -1;
        return this.head.getData();
    }

    @Override
    public void enqueue(int min) {
        Node v = new Node(min);
        if(size == 0) head = tail = v;
        else {
            tail.setNext(v);
            tail = v;
        }
        size++;
    }//end enqueue

    @Override
    public int dequeue() {
        if(size == 0) {
            System.out.println("List Queue is empty");
            return -1;
        }
        int temp = head.getData();
        if(size == 1) head = tail = null;
        else {
            head = head.getNext();
        }
        size--;
        return temp;
    }//end dequeue

}//end ListQueue class
