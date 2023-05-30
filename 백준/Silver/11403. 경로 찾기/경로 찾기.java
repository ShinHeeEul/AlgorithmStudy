import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main
{

    static boolean[][] arr;
    static int[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 1) arr[i][j] = true;
            }

        }

        int[][] answer = new int[N][N];
        for(int i = 0; i < N; i++) {
            visited = new int[N];
            DFS(i, false);
            answer[i] = visited.clone();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                System.out.print(answer[i][j] + " ");
            System.out.println();
        }
    }

    private static void DFS(int start, boolean first) {
        if(visited[start] == 1) return;
        if(first) visited[start] = 1;
        for(int i = 0; i < arr[start].length; i++) {
            if(arr[start][i]) DFS(i, true);
        }
    }
}