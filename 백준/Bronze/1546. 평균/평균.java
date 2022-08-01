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

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        float sum = 0;
        int max = 0;
        int[] x = new int[N];
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            if(max < x[i]) max = x[i];
        }
        for(int i = 0; i < N; i++) {
            sum += ((float)x[i])/max * 100;
        }

        bw.write(sum/N + "");


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}