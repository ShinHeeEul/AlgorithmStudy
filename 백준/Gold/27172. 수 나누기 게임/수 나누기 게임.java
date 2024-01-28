import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = read();

        int[] arr = new int[N];
        int INF = 1000001;
        int[] point = new int[INF];
        for(int i = 0; i < N; i++) {
            int a = read();
            for(int j = 2; j * a < INF; j++) point[j * a]--;

            for(int j = 1; j * j <= a; j++) {
                if(a % j == 0) {
                    point[j]++;
                    if(j != a / j) {
                        point[a / j]++;
                    }
                }
            }
            point[a]--;
            arr[i] = a;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(point[arr[i]]).append(" ");
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
