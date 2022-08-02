import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        char[] ch_A = (A+"").toCharArray();
        char[] ch_B = (B+"").toCharArray();

            char tmp;

            tmp = ch_A[2];
            ch_A[2] = ch_A[0];
            ch_A[0] = tmp;
            tmp = ch_B[2];
            ch_B[2] = ch_B[0];
            ch_B[0] = tmp;

        if(Integer.parseInt(String.valueOf(ch_A)) > Integer.parseInt(String.valueOf(ch_B)))
            System.out.println(String.valueOf(ch_A));
        else System.out.println(String.valueOf(ch_B));
        br.close();
        bw.close();
    }
}