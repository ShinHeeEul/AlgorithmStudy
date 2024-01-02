import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());
            int round = Integer.parseInt(st.nextToken());
            int kim = Integer.parseInt(st.nextToken()) - 1;
            int lim = Integer.parseInt(st.nextToken()) - 1;

            for(int i = 2; ; i *= 2) {
                if((kim / i) == (lim / i)) {
                    System.out.println((int) (Math.log(i) / Math.log(2)));
                    return;
                }
            }
        }
}