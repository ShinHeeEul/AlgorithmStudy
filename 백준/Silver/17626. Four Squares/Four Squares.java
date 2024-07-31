import java.util.ArrayList;
import java.util.Arrays;

class Main {
    final int MAX = 223;
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] dp = new int[100000];

        Arrays.fill(dp, 5);
        for(int i = 0; i < 223; i++) {
            dp[i*i] = 1;
        }
        for(int i = 0; i < 50000; i++){
            for(int j = 0; j < 223; j++) {
                int a = i + j * j;
                dp[a] = Math.min(dp[a], dp[i] + 1);
            }
        }

        System.out.println(dp[N]);

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