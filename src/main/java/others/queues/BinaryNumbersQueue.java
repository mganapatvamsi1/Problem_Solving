package others.queues;

import java.util.LinkedList;
import java.util.Queue;

/* Generate Binary numbers from 1 to N using a Queue in Java. */
public class BinaryNumbersQueue {

    public String[] generateBinary(int number) {
        String[] resultFinal = new String[number];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < number; i++) {
            resultFinal[i] = queue.poll();
            String s1 = resultFinal[i] + "0";

            String s2 = resultFinal[i] + "1";
            queue.offer(s1);
            queue.offer(s2);
        }
        return resultFinal;
    }


    public static void main(String[] args) {

    }
}
