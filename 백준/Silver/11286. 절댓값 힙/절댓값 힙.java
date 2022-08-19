import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    static class obj implements Comparable{
        private int a;

        public obj(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        @Override
        public int compareTo(Object o) {
            obj O = (obj) o;
            if(Math.abs(this.a) > Math.abs(O.getA()))
                return 1;
            else if(Math.abs(this.a) < Math.abs(O.getA())) return -1;
            else {
                if(this.a < O.getA()) return -1;
                else return 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        PriorityQueue<obj> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i =0 ;i < N ;i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                obj tmp = minHeap.poll();
                System.out.println(tmp == null?0:tmp.getA());
            }
            else
                minHeap.add(new obj(x));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}