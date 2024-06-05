import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        int count = 0;
        int before = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(0);
        // 여기서 pop 했을떄?
        for(int i = 0 ; i < N; i++) {
            //얘가 pq에 있다면? 냅두고, 없다면 + 1하고 pq에 넣고
            read();
            int y = read();
            if(before < y) count++;
            else {
                int a = -1;
                if(!pq.isEmpty()) {
                    while (( a= pq.peek()) > y) {
                        pq.poll();
                        if(pq.isEmpty()) break;
                    }
                }
                // 있다면?
                if(a != y) count++;
                else pq.poll();
            }
            pq.add(y);
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

