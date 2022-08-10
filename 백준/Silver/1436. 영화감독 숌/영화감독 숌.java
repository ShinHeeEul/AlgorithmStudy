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

        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int num = 666;
        for(int i = 0; sum < N; i++) {
            num++;
            String S = Integer.toString(num);
            if(S.contains("666")) sum++;
        }

        bw.write(num + "");

        bw.flush();
        br.close();
        bw.close();
    }
}