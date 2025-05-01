public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int K = read();

        Fruit[] arr = new Fruit[K];

        // 땅 상태
        // m일 번째에 k번째을 수확할거다.
        int[][] dp = new int[M + 1][K];


        for(int i = 0; i < K; i++) {
            arr[i] = new Fruit(read(), read(), read());
            if(arr[i].first > M) continue;
            // arr[i].first의 날에 i번째 열매를 수확할거다
            dp[arr[i].first][i] = arr[i].c;
        }



        // 날짜

        int max = 0;
        for(int i = 0; i < M; i++) {
                // 현재 어떤 열매가 심어져있냐
                for(int j = 0; j < K; j++) {
                    // 심겨져 있는 놈이 없다면? continue;
                    if(dp[i][j] == 0) continue;
                    // 수확한 뒤 어떤 종류의 열매를 심을거냐
                    for(int k = 0; k < K; k++) {
                        int a = i + arr[k].first;
                        // 심겨져 있는 열매 종류와 심을 열매 종류가 같다면?
                        if(k == j) a = i + arr[k].nxt;
                        if(a > M) continue;
                        dp[a][k] = Math.max(dp[a][k], dp[i][j] + arr[k].c);
                    }
                }
        }

        for(int i = 0; i < K; i++) {
            for(int j = 0; j <= M; j++) {
                max = Math.max(max, dp[j][i]);
            }
        }

        System.out.println(max * N);
    }

    static class Fruit {
        int first;
        int nxt;
        int c;

        public Fruit(int a, int b, int c) {
            this.first = a;
            this.nxt = Math.min(first, b);
            this.c = c;
        }
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
