import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        String ans = br.readLine();
        for(int i = 1; i < N; i++) {
            String S = br.readLine();
            for(int j = 0; j < S.length(); j++) {
                if(ans.charAt(j) != S.charAt(j)) ans = ans.substring(0,j) + '?' + ans.substring(j+1,S.length());
            }
        }

        System.out.println(ans);

        bw.flush();
        br.close();
        bw.close();
    }
}