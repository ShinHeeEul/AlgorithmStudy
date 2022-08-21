import java.io.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        if(N == 1) System.out.println(1);
        else {
            int tmp = 1;
            int i;
            for(i = 0; tmp < N;i+=6) {
                tmp = tmp + i;
            }
            System.out.println(i/6);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}