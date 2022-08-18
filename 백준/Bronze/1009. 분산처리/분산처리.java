import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = a;
            if(b == 1) tmp = tmp % 10;
            for(int j = 1; j < b; j++) {
                tmp = (tmp * a) % 10;
            }
            System.out.println(tmp==0?10:tmp);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}