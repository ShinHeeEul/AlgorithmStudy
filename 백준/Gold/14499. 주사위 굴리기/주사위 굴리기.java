import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2,1,-1,0,0};
    static int[] dy = {2,0,0,-1,1};
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();
        int M = read();
        int y = read() + 1;
        int x = read() + 1;
        int K = read();

        map = new int[N+2][M+2];
        int[] dice = new int[7];
        int[] diceIndex = {0,3,4,2,5};
        int bottomIndex = 1;
        Arrays.fill(map[0], -1);
        Arrays.fill(map[N+1], -1);
        for(int i = 1; i <= N; i++) {
            Arrays.fill(map[i], -1);
            for(int j = 1; j <= M; j++) {
                map[i][j] = read();
            }
        }
        for(int i = 0; i < K; i++) {
            //방향
            int index = read();
            int xx = dx[index];
            int yy = dy[index];
            int cur = map[y + yy][x + xx];
            if(cur == -1) {
                continue;
            }
            x += xx;
            y += yy;
            int di = diceIndex[index];
            if(cur == 0) map[y][x] = dice[di];
            else {
                dice[di] = cur;
                map[y][x] = 0;
            }
            diceIndex[index] = getRev(bottomIndex);
            diceIndex[getRevDir(index)] = bottomIndex;
            bottomIndex = di;
            bw.write(dice[getRev(bottomIndex)] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

    private static int getRevDir(int index) {
        if(index == 1) return 2;
        if(index == 2) return 1;
        if(index == 3) return 4;
        if(index == 4) return 3;
        return -1;
    }
    private static int getRev(int a) {
        return 7 - a;
    }
}
