//Author: Joseph Byrne

import java.util.Scanner;

public class ArrayQueue implements Queue{
    protected int capacity;
    protected int[] ArrayQi;
    protected int head;
    protected int tail;
    protected int size;
    private Scanner fin;

    public ArrayQueue(Scanner fin) {
        capacity = 10;
        ArrayQi = new int[capacity];
        head = -1;
        tail = -1;
        size = 0;
        this.fin = fin;
    }//end constructor

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int front() {
        if(size == 0) return -1;
        else return ArrayQi[head];
    }

    @Override
    public void enqueue(int data) {
        if(size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        if(size == 0) {
            ArrayQi[0] = data;
            head = tail = 0;
        }
        else {
            tail = (tail + 1) % capacity;
            ArrayQi[tail] = data;
        }
        size++;
    }//end enqueue

    @Override
    public int dequeue() {
        if(size == 0) {
            System.out.println("Array Queue is empty");
            return -1;
        }
        int temp = ArrayQi[head];
        if(size == 1) head = tail = -1;
        else {
            head = (head + 1) % capacity;
        }
        size--;

        if ((fin.hasNextLine())) enqueue(Integer.parseInt(fin.nextLine()));
        return temp;
    }//end dequeue

    public boolean isEmpty() {
        if(size <= 0) return true;
        else return false;
    }

}//end ArrayQueue class
