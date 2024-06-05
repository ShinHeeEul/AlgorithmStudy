import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int count = 0;
        int before = 0;
        Stack<Integer> pq = new Stack<>();
        pq.add(0);
        for(int i = 0 ; i < N; i++) {
            read();
            int y = read();
            if(before < y) count++;
            else {
                while (pq.peek() > y) {
                    pq.pop();
                }
                // 있다면?
                if(pq.peek() != y) count++;
                else pq.pop();
            }
            pq.push(y);
            before = y;
        }
        System.out.println(count);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

