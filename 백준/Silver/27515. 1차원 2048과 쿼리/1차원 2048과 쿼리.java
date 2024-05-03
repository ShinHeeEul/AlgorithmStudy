import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        long Q = read();
        int N = 63;
        int[] arr = new int[N];
        double log2 = Math.log(2);
        StringBuilder sb = new StringBuilder();
        long before = 0;
        for(int i = 0; i < Q; i++) {
            char c = (char) System.in.read();
            long l = read();
            if(l == 0) {
                sb.append(before).append("\n");
                continue;
            }
            int index = (int) (Math.log((double) l) / log2);
            arr[index] += (c=='+'?1 : -1);

            int max = 0;
            int next = 0;
            for(int j = 0; j < N-1; j++) {
                next = (arr[j] + next) >> 1;
                if(arr[j + 1] + next > 0) max = Math.max(max, j + 1);
            }
            if(arr[0] == 0 && max == 0) before = 0;
            else before = Double.valueOf(Math.pow(2, max)).longValue();

            sb.append(before).append("\n");
        }
        System.out.println(sb);
    }
    private static long read() throws Exception {
        long d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
