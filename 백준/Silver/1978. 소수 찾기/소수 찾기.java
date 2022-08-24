import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        boolean check = true;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++) {
            check = true;
            int tmp = Integer.parseInt(st.nextToken());
            if((tmp == 1)) check = false;
            for(int j = 2; j < tmp-1;j++) {
                if(tmp%j == 0) {
                    check = false;
                    break;
                }
            }
            if(check)
                sum++;
        }

        System.out.println(sum);


        bw.flush();
        br.close();
        bw.close();
    }
}