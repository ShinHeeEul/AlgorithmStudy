import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
            pq.add(read());

        if(N == 0) {
            System.out.println(0);
            return;
        }

        long size = Math.round((float) pq.size() * 0.15);

        for(int i = 0; i < size; i++) pq.poll();

        int sum = 0;
        int aa = 0;
        while(pq.size() > size) {
            aa++;
            sum += pq.poll();
        }

        System.out.println(Math.round((float) sum / aa));
    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}