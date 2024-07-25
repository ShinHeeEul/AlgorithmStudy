import java.util.Comparator;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++) {
            int a = read();
            if(a < 0) minusPq.add(a);
            else plusPq.add(a);
        }

        int max = 0;
        int ans = 0;

        while(!plusPq.isEmpty()) {
            int tmp = plusPq.poll();
            int a = M-1;

            max = Math.max(max, tmp);
            while(!plusPq.isEmpty() && (a != 0)) {
                a--;
                plusPq.poll();
            }

            ans += tmp;
        }

        while(!minusPq.isEmpty()) {
            int tmp = minusPq.poll();
            int a = M-1;

            max = Math.max(max, -tmp);
            while(!minusPq.isEmpty() && (a != 0)){
                a--;
                minusPq.poll();
            }
            ans -= tmp;
        }

        System.out.println(ans * 2 - max);

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