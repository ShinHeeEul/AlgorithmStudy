class Main {

    static int[][] arr;
    static int[][] turn;

    static int[] di = {1, 0, -1 , 0};
    static int[] dj = {0, 1, 0, -1};
    static int N;
    static int M;
    static int R;
    static int size;
    public static void main(String args[]) throws Exception {
        N = read();
        M = read();
        R = read();

        arr = new int[N][M];
        turn = new int[N][M];

        size = Math.min(N, M) >> 1;


        // 돌아가는 거
        // 범위 밖으로 가게 되었을 때? 방향 전환
        // 대각선으로 체크

        for(int i = 0; i < N; i++) {
            for(int j =0; j < M; j++) {
                arr[i][j] = read();
                turn[i][j] = arr[i][j];
            }
        }


        rolling(0);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(turn[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    public static void rolling(int depth) {


        if(size == depth) {
            return;
        }


        for(int a = 0; a < R % (((N + M - (depth << 2))  << 1) - 4); a++) {
            int[] dir = new int[size];
            int i = depth;
            int j = depth;
            int tmp = turn[depth][depth];

            for (int t = 0; t < ((N + M - (depth << 2)) << 1) - 4; t++) {
                // 범위 밖으로 튀어 나갔다? 방향 바꾸고

                i += di[dir[depth]];
                j += dj[dir[depth]];
                if (t != 0 && !check(i, j, depth)) {
                    i -= di[dir[depth]];
                    j -= dj[dir[depth]];
                    dir[depth]++;
                    dir[depth] %= 4;
                    i += di[dir[depth]];
                    j += dj[dir[depth]];
                }
                int ttmp = turn[i][j];
                turn[i][j] = tmp;
                tmp = ttmp;
            }
        }

        rolling(depth + 1);
    }




    private static boolean check(int i, int j, int li) {
        return i >= li && j >= li && i < (N - li) && j < (M - li);
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }

}