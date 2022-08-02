import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        char[] ch = br.readLine().toCharArray();
        int[] ans = new int[26];

        Arrays.fill(ans,-1);


        for(int i = 0; i < ch.length; i++) {
            if(ans[ch[i]-'a'] == -1)
                ans[ch[i]-'a'] = i;
        }

        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));

        br.close();
        bw.close();
    }
}