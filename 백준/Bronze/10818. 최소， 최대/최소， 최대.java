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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = -1000000;
        int min = 1000000;
        for(int i = 0; i < N;i++) {
            int a = Integer.parseInt(st.nextToken());
            if(max < a) max = a;
            if(min > a) min = a;
        }

        bw.write(min + " " + max);

        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}