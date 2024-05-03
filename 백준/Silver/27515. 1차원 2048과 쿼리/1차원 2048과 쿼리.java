import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        long Q = read();
        int N = 63;
        int[] arr = new int[N];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            char c = (char) System.in.read();
            long l = read();
            if(l != 0) {
                int index = (int) (Math.log((double) l) / Math.log(2));
                if(index >= 0 && index <= N-1) {
                    arr[index]= arr[index] + (c=='+'?1 : -1);
                }
            }
            int[] tmp = arr.clone();
            for(int j = 0; j < N-1; j++) {
                if(tmp[j] >= 2) {
                    tmp[j + 1] += tmp[j] / 2;
                }
            }
            for(int j = N-1; j >= 0; j--) {
                if(j == 0 && tmp[j] == 0) {
                    sb.append(0).append("\n");
                    break;
                }
                if(tmp[j] >= 1) {
                    sb.append(Double.valueOf(Math.pow(2, j)).longValue()).append("\n");
                    break;
                }
            }
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
