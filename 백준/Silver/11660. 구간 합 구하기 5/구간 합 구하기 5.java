import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int[][] table = new int[N][N];
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            for(int j = 1; j < N; j++) {
                table[i][j] = table[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;


            if(y1 == 0) {
                for(int j = x1; j <= x2; j++) {
                    sum += table[j][y2];
                }
                bw.write(sum + "\n");
            }

            else {
                for(int j = x1; j <= x2; j++) {
                    sum += table[j][y2] - table[j][y1-1];
                }
                bw.write(sum + "\n");
            }

        }

        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}