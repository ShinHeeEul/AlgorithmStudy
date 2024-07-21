import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static ArrayList<Integer> answer;
    static int[] stair;
    static boolean[] visit;
    static int max;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stair = new int[N+1];
        visit = new boolean[N+1];
        int[][] S = new int[N+1][N+1];

        for(int i = 0; i < N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        S[0][0] = stair[0];
        S[1][0] = stair[1];
        S[1][1] = stair[0] + stair[1];

        for(int i = 2; i < N; i++) {
            S[i][0] = Math.max(S[i-2][0] + stair[i], S[i-2][1] + stair[i]);
            S[i][1] = S[i-1][0] + stair[i];
        }

        System.out.println(Math.max(S[N-1][0], S[N-1][1]));
        }
}
