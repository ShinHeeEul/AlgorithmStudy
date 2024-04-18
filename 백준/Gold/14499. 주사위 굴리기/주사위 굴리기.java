import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2,1,-1,0,0};
    static int[] dy = {2,0,0,-1,1};
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken()) + 1;
        int x = Integer.parseInt(st.nextToken()) + 1;
        int K = Integer.parseInt(st.nextToken());

        map = new int[N+2][M+2];
        int[] dice = new int[7];
        int[] diceIndex = {0,3,4,2,5};
        int bottomIndex = 1;
        Arrays.fill(map[0], -1);
        Arrays.fill(map[N+1], -1);
        for(int i = 1; i <= N; i++) {
            Arrays.fill(map[i], -1);
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            //방향
            int index = Integer.parseInt(st.nextToken());
            x += dx[index];
            y += dy[index];
            if(map[y][x] == -1) {
                x -= dx[index];
                y -= dy[index];
                continue;
            }
            int di = diceIndex[index];
            if(map[y][x] == 0) map[y][x] = dice[di];
            else {
                dice[di] = map[y][x];
                map[y][x] = 0;
            }
            //다이스 동서남북 // 굴렸을 때

            diceIndex[index] = getRev(bottomIndex);
            diceIndex[getRevDir(index)] = bottomIndex;
            bottomIndex = di;
            System.out.println(dice[getRev(bottomIndex)]);
        }
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
        if(a == 1) return 6;
        if(a == 2) return 5;
        if(a == 3) return 4;
        if(a == 4) return 3;
        if(a == 5) return 2;
        if(a == 6) return 1;
        return -1;
    }
}
