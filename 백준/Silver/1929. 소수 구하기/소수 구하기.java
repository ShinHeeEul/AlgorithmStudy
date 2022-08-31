import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i = M; i <= N; i++) {
            boolean check = true;
            if(i == 1) continue;
            for(int j = 2; j <= (int)Math.sqrt(i); j++) {
                if(i % j == 0) check = false;
            }
            if(check) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}