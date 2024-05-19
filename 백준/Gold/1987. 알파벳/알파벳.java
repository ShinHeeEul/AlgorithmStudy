import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited = new boolean[27];
    static char[][] arr;
    static int count = 0;

    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[R+2][C+2];

        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                arr[i][j] = s.charAt(j-1);
            }
        }

        dfs(0, 1 ,1);

        System.out.println(count ==0?1:count);
    }

    static void dfs(int cnt,int i, int j) {
        int v = arr[i][j] - 'A';
        if(visited[v]) {
            count = Math.max(count, cnt);
            return;
        }
        visited[v] = true;

        for(int k = 0 ; k < 4; k++) {
            if(arr[i + dc[k]][j + dr[k]] != '\u0000') {
                dfs(cnt+1, i+dc[k], j+dr[k]);
            }
        }

        visited[v] = false;

    }

}
