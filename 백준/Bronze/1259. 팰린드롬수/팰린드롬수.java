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
        String S;
        while(!(S = br.readLine()).equals("0")) {
            StringBuffer sb = new StringBuffer(S);
            System.out.println(S.equals(sb.reverse().toString())?"yes":"no");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}