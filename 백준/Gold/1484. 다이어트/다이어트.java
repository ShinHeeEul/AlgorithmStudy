import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        int G  = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(long remember = 1; remember <= G; remember++) {
            double current = Math.sqrt(G + remember * remember);
            int ic = (int) current;
            if(current == ic) pq.add(ic);
        }
        if(pq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
