import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        boolean check = false;
        String ans = "";
        int max = (54>N)?N:54;
        for(int i = 0; i < max; i++) {
            int cons = N-i;
            String S = Integer.toString(cons);
            for(int j = 0; j < S.length(); j++) {
                cons += Integer.parseInt(S.charAt(j) + "");
            }
            if (cons == N) {
                check = true;
                ans = S;
            }
        }
        if(!check) System.out.println(0);

        else System.out.println(ans);
        bw.flush();
        br.close();
        bw.close();
    }
}