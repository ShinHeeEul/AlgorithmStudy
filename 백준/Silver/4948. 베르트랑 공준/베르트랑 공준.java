import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);


        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[246913];
        check[0] = check[1] = true;
        for (int j = 2 ; j <= (int) Math.sqrt(check.length); j++) {
            if(check[j]) continue;
            for(int k = j *j; k < check.length; k += j) {
                check[k] = true;
            }
        }
        while(N != 0) {
            int sum = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if(!check[i]) sum++;
            }
            bw.write(sum + "\n");
            N = Integer.parseInt(br.readLine());
        }
        bw.flush();
        br.close();
        bw.close();
    }
}