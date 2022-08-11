import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.stream.Stream;


public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        final int M = 1234567891;
        String S = br.readLine();
        long hash = 0;
        long pow = 1;
        for(int i = 0; i < N; i++) {
            hash += ((S.charAt(i)-'a' + 1) * pow);
            pow = (pow * 31) % M;
        }

        bw.write(hash % M + "");

        bw.flush();
        br.close();
        bw.close();
    }
}