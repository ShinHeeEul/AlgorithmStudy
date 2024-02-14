import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int[][] arr;
    static int[][] visit;
    static int[][] dir = { {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visit = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =1 ; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                visit[i][j] = -1;
            }
        }

        bw.write(dfs(1,1) + "\n");
        bw.flush();
        bw.close();
    }

    private static int dfs(int i, int j) {
        if(i == N && j == M) return 1;

        if (visit[i][j] != -1) {
            return visit[i][j];
        }

        visit[i][j] = 0;

        for(int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];

            if (x < 1 || y < 1 || x > N || y > M) {
                continue;
            }

            if(arr[x][y] < arr[i][j]) visit[i][j] += dfs(x,y);
        }

        return visit[i][j];
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
