import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        long Q = read();
        int N = 63;
        int[] arr = new int[N];
        double log2 = Math.log(2);
        long before = 0;
        for(int i = 0; i < Q; i++) {
            int change = System.in.read() == 43? 1: -1;
            long l = read();
            if(l == 0L) {
                bw.write(Long.toString(before));
                bw.write("\n");
                continue;
            }
            int index = (int) (Math.log((double) l) / log2);
            arr[index] += change;

            int max = 0;
            int next = 0;
            for(int j = 0; j < N-1; j++) {
                next = (arr[j] + next) >> 1;
                if(arr[j + 1] + next > 0) max = Math.max(max, j + 1);
            }
            if((arr[0] | max) == 0) before = 0;
            else before = (long) Math.pow(2,max);
            bw.write(Long.toString(before));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    private static long read() throws Exception {
        long d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
