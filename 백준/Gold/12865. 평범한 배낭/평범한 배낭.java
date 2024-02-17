import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int K = read();

        Item[] arr = new Item[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = new Item(read(), read());
        }
        //K만큼 넣을 수 있는데 이중에 제일 베스트가 되게 넣어라
        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            Item item = arr[i];
            for(int j = 1; j <= K; j++) {
                if (item.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.weight] + item.value);
                }
            }
        }

        System.out.println(dp[N][K]);


    }

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
