import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        App[] apps = new App[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            int val = Integer.parseInt(st2.nextToken());
            max += val;
            apps[i] = new App(Integer.parseInt(st.nextToken()),
                    val);
        }

        int[] dp = new int[max+1];
        for(App app : apps) {
            int memory = app.memory;
            int cost = app.cost;
            for(int i = max; i >= cost; i--) dp[i] = Math.max(dp[i], dp[i - cost] + memory);
        }

        int index = 0;
        while(dp[index] < M) index++;
        System.out.println(index);
    }

    public static class App {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }
}