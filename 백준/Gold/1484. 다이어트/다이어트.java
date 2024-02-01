import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {

        int G  = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(long remember = 1; remember < 100000; remember++) {
            double current = Math.sqrt(G + remember * remember);
            if(current == (int) current) {
                pq.add((int) current);
            }
        }
        if(pq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
