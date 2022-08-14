import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] len = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int time = Integer.MAX_VALUE;
        int height = 0;
        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                len[i][j] = Integer.parseInt(st.nextToken());
                if(max < len[i][j]) max = len[i][j];
                if(min > len[i][j]) min = len[i][j];
            }
        }

        for(int k = min; k <= max; k++) {
            int tmp_height = k;
            int tmp_time = 0;
            int tmp_B = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (len[i][j] < tmp_height) {
                            tmp_B -= (tmp_height - len[i][j]);
                            tmp_time += (tmp_height - len[i][j]);

                    }
                    else if (len[i][j] > tmp_height) {
                            tmp_B += (len[i][j] - tmp_height);
                            tmp_time += (len[i][j] - tmp_height)*2;
                    }
                }

            }
            if (tmp_B >= 0) {
                if (time >= tmp_time) {
                    time = tmp_time;
                    height = tmp_height;
                }
            }
        }

        bw.write(time + " " + height);


        bw.flush();
        br.close();
        bw.close();
    }
}