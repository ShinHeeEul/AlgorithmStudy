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
        String S = br.readLine();
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st;

        char[] ch = S.toCharArray();

        int[][] ans = new int[ch.length][26];

        ans[0][ch[0] - 'a']++;
        for(int i = 1; i < ch.length; i++) {
            for(int j = 0; j < 26; j++) {
                ans[i][j] = ans[i-1][j];
            }
            ans[i][ch[i] - 'a']++;
        }

        for(int i = 0; i < Q; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine()," ");
            char a = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == 0)  sum = ans[end][a - 'a'];
            else  sum = ans[end][a - 'a'] - ans[start - 1][a - 'a'];
            bw.write(sum + "\n");
        }
        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}