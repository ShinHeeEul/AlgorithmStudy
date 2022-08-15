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

        int C = Integer.parseInt(br.readLine());

        for(int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] student = new int[N];
            for(int j = 0; j < N; j++) {
                student[j] = Integer.parseInt(st.nextToken());
                sum += student[j];
            }
            int avg = sum / N;
            int over = 0;
            for(int j = 0;  j < N; j++) {
                if((student[j] - avg) > 0) over++;
            }
            float result = ((float) over)/N * 100;
            System.out.printf("%.3f",result);
            System.out.println("%");

        }

        bw.flush();
        br.close();
        bw.close();
    }
}