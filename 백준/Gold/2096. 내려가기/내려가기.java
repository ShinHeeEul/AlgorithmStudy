public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();

        int[][] arr = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;



        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = read();
            }
        }

        dp[0] = arr[0].clone();

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1])) + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            max = Math.max(max, dp[N-1][i]);
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N-1][i]);
        }

        System.out.println(max + " " + min);

    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}