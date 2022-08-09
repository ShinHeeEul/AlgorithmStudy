import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static int backtracking(int N, int a, int sum) throws IOException {

        sum++;
        String S;

        if(a < 10) S = "0" + a;
        else S = Integer.toString(a);

        int next  = Integer.parseInt(S.substring(1,2));
        a = next + Integer.parseInt(S.substring(0,1));
        if(a < 10) S = "0" + a;
        else S = Integer.toString(a);

        a = Integer.parseInt(next + S.substring(1,2) + "");
         if(N == a) return sum;
         sum = backtracking(N, a, sum);


        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        sum = backtracking(N,N,sum);


        bw.write(sum + "");






        bw.flush();
        br.close();
        bw.close();
    }
}