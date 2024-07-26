import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) pq.add(read());

        int sum = 1;
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(sum < a) break;
            sum += a;
        }
        System.out.println(sum);
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