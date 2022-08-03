import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int end = 0;
        for(int i = 0; i < M;i++) {
            sum += Math.pow(N+1,i);
        }
        for(int i = 0; i < M;i++) {
            end += N * Math.pow(N+1, i);
        }
        for(int i = 0; (sum + i) <= end; i++) {
            int k  = sum + i;
            String S = "";
            while(k > 0) {
                S = (k % (N+1)) + " " + S;
                k /= (N+1);
            }
            if(S.contains("0")) {
                continue;
            }
            bw.write(S + "\n");
        }
        br.close();
        bw.close();
    }
}