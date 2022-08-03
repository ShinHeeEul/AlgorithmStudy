import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static char change(char c) {
        if(c == 'B') c = 'W';
        else c = 'B';
        return c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println("Case #" + (i+1) +": "+(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));


        }


        br.close();
        bw.close();
    }
}