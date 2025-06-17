import java.io.*;
import java.util.*;

class Main {

    static int[][] arr;
    static int[] dist;
    static int N;
    static Queue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];


        for (int i = 0; i < N + 1; i++) {
            arr[i] = new int[N + 1];
            Arrays.fill(arr[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(arr[s][e] > v) arr[s][e] = v;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        pq = new LinkedList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        dij(start);



        bw.write(dist[end] + "");
        bw.flush();
        bw.close();
    }

    public static void dij(int start) {
        pq.add(start);
        while (!pq.isEmpty()) {
            int n = pq.poll();
            for (int i = 0; i < arr[n].length; i++) {
                if (arr[n][i] == Integer.MAX_VALUE) continue;
                int tmp = arr[n][i];
                if (dist[i] > dist[n] + tmp) {
                    dist[i] = dist[n] + tmp;
                    pq.add(i);
                }
            }
        }
    }
}