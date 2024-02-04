public class Main {
    static int N;
    static int[][] map;
    static int bCnt;
    static int wCnt;
    public static void main(String[] args) throws Exception {
        N = read();

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = read();
            }
        }

        BlackBackTracking(0, 0, 0);
        WhiteBackTracking(0, 1, 0);
        System.out.println(bCnt + wCnt);
    }

    public static void WhiteBackTracking(int i, int j, int count) {
        if(count > bCnt) {
            bCnt = count;
        }
        if(j >= N) {
            i += 1;
            j = (i%2 == 0)?1:0;
        }

        if(i >= N) return;

        if(map[i][j] == 1) {
            boolean b = true;
            for(int k = 0; k < N; k++) {
                if((i + k < N) && (j + k < N)) {
                    if(map[i+k][j+k] == 2) {
                        b = false;
                        break;
                    }
                }
                if((i + k < N) && (j - k >= 0)) {
                    if(map[i+k][j-k] == 2) {
                        b = false;
                        break;
                    }
                }
                if((i - k >= 0) && (j + k < N)) {
                    if(map[i-k][j+k] == 2) {
                        b = false;
                        break;
                    }
                }
                if((i - k >= 0) && (j - k >= 0)) {
                    if(map[i-k][j-k] == 2) {
                        b = false;
                        break;
                    }
                }
            }
            if(b) {
                map[i][j] = 2;
                WhiteBackTracking(i, j + 2, count + 1);
                map[i][j] = 1;
            }
        }
        WhiteBackTracking(i, j + 2, count);
    }

    public static void BlackBackTracking(int i, int j, int count) {
        if(count > wCnt) {
            wCnt = count;
        }
        if(j >= N) {
            i += 1;
            j = (i%2 == 0)?0:1;
        }

        if(i >= N) return;

        if(map[i][j] == 1) {
            boolean b = true;
            for(int k = 0; k < N; k++) {
                if((i + k < N) && (j + k < N)) {
                    if(map[i+k][j+k] == 2) {
                        b = false;
                        break;
                    }
                }
                if((i + k < N) && (j - k >= 0)) {
                    if(map[i+k][j-k] == 2) {
                        b = false;
                        break;
                    }
                }
                if((i - k >= 0) && (j + k < N)) {
                    if(map[i-k][j+k] == 2) {
                        b = false;
                        break;
                    }
                }
                if((i - k >= 0) && (j - k >= 0)) {
                    if(map[i-k][j-k] == 2) {
                        b = false;
                        break;
                    }
                }
            }
            if(b) {
                map[i][j] = 2;
                BlackBackTracking(i, j + 2, count + 1);
                map[i][j] = 1;
            }
        }
        BlackBackTracking(i, j + 2, count);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
