import java.io.*;
import java.math.BigInteger;
//import java.io.InputStreamReader;
import java.util.*;

public class challenge {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while (s.hasNextInt()) {
            int n = s.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.reverseOrder());

            boolean[] arr = { true, true, true };
            int w = 3;

            for (int i = 0; i < n; i++) {
                int k = s.nextInt();
                int j = s.nextInt();

                if (k == 1) {
                    queue.add(j);
                    stack.add(j);
                    pqueue.add(j);
                    continue;
                }

                if (arr[0]) {
                    try {
                        if (queue.poll() != j) {
                            arr[0] = false;
                            w--;
                        }
                    } catch (Exception e) {

                        arr[0] = false;
                        w--;
                    }
                }

                if (arr[1]) {
                    try {
                        if (stack.pop() != j) {
                            arr[1] = false;
                            w--;
                        }
                    } catch (Exception e) {
                        arr[1] = false;
                        w--;
                    }
                }

                if (arr[2]) {
                    try {

                        if (pqueue.poll() != j) {
                            arr[2] = false;
                            w--;
                        }
                    } catch (Exception e) {
                        arr[2] = false;
                        w--;
                    }
                }
            }

            if (w == 0) {
                System.out.println("impossible");
                continue;
            }
            if (w > 1) {
                System.out.println("not sure");
                continue;
            }
            String r = arr[0] ? "queue" : arr[1] ? "stack" : "priority queue";
            System.out.println(r);
            s.nextLine();
        }
    }
}
