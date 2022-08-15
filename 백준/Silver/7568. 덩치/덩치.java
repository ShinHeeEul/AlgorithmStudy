import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        int[][] P = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            P[i][0] = Integer.parseInt(st.nextToken());
            P[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[N];
        for(int i = 0; i < N; i++) {
            rank[i] = 1;
            for(int j = 0; j < N; j++) {
                if((P[i][0] < P[j][0]) && (P[i][1] < P[j][1])) rank[i]++;
            }
            System.out.print(rank[i] + " ");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}