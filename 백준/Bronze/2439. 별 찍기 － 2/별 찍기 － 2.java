import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        int N = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N-i; j++) bw.write(" ");
            for(int j = 1; j <= i;j++)  bw.write("*");
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}