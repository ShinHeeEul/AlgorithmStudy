import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for(int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int remain = N % 42;
            if(map.containsKey(remain));
            else {
                ans++;
                map.put(remain, 1);
            }
        }
        bw.write(ans + "");
        br.close();
        bw.close();
    }
}