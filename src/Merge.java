//Author: Joseph Byrne

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) throws FileNotFoundException {

        int fileCount = args.length;

        ArrayQueue[] BossArray = new ArrayQueue[fileCount]; //empty array of FIFO objects initialized

        for(int i = 0; i < fileCount; i++) {
            Scanner fin = new Scanner(new File(args[i])); // file input being read for each file "i"
            int counter = 0; //to track reading in first 10 ints
            ArrayQueue fifo = new ArrayQueue(fin);
            while(fin.hasNextLine() && counter < 10) {
                fifo.enqueue(Integer.parseInt(fin.nextLine()));
                counter++;
            }
            BossArray[i] = fifo;
        }

        ListQueue ResultQ = new ListQueue();

       while(!isEmpty(BossArray)) {
           int index = getMinIndex(BossArray);

           int value = BossArray[(index)].dequeue();
           ResultQ.enqueue(value);
       }

        while (ResultQ.size() > 0) {
            System.out.println(ResultQ.dequeue());
        }

    }//end main

        //helper methods

        public static int getMinIndex(ArrayQueue[] BossArray) {
            int index = 0;
            while (BossArray[index].isEmpty()) {
                index++;
            }
            int min = BossArray[index].front();
            for(int i = 0; i < BossArray.length; i++) {
                if(!BossArray[i].isEmpty() && BossArray[i].front() < min) {
                    min = BossArray[i].front();
                    index = i;
                }
            }
            return index;
        }//end getMinIndex

        public static boolean isEmpty(ArrayQueue[] BossArray) {
            for(int i = 0; i < BossArray.length; i++) {
                if(!BossArray[i].isEmpty()) return false;
            }
            return true;
        }//end isEmpty

}//end Merge Class
