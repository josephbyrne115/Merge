import java.util.Scanner;

public interface Queue {
    public int size();  // return the number of items currently in the queue.
    public int front(); // return the item at the head of the queue, but do not remove it from the queue.
    public void enqueue(int data); // insert the new item into the tail of the queue.
    public int dequeue(); // return and remove the item at the head of queue.

}//end Queue
