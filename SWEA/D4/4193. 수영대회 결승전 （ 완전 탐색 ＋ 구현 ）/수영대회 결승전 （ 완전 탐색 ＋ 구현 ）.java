import java.io.*;
import java.util.*;
 
          
public class Solution {
 
             
            static int[][] arr;
    static int N;
    static int[] start;
    static int[] end;
    static boolean[][] visited;
     
            static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
     
            public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for(int t = 1; t <= T; t++) {
             
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
             
            StringTokenizer st;
             
            for(int i = 0; i < N ; i++) {
                st = new StringTokenizer(br.readLine());
                 
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            start = new int[2];
            end = new int[2];
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
             
            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }
         
        System.out.println(sb);
    }
     
            public static boolean check(int i, int j) {
         
        if(i < 0 || j < 0 || j >= N || i >= N) return false;
        if(arr[i][j] == 1 || visited[i][j]) return false;
        return true;
    }
     
            public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
         
        queue.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
         
        while(!queue.isEmpty()) {
            Node n = queue.poll();
             
            int ni = n.i;
            int nj = n.j;
            int nc = n.count;
             
            boolean canGo = nc % 3 == 2;
             
            if(ni == end[0] && nj == end[1]) return nc;
             
            for(int i = 0; i < 4; i++) {
                int ii = ni + di[i];
                int jj = nj + dj[i];
                 
                if(!check(ii, jj)) continue;
                 
                if(arr[ii][jj] == 2 && !canGo) {
                    queue.add(new Node(ni, nj, nc + 1));
                    continue;
                }
                 
                visited[ii][jj] = true;
                queue.add(new Node(ii, jj, nc + 1));
            }
        }
         
        return -1;
    }
     
            public static class Node {
        int i;
        int j;
        int count;
         
                Node (int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
  
          
}