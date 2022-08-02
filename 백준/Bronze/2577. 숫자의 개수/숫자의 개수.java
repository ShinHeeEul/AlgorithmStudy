import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        char[] ch = ("" + A*B*C).toCharArray();
        int[] sum = new int[10];
        for(int i = 0; i < ch.length;i++) sum[Character.getNumericValue(ch[i])]++;

        Arrays.stream(sum).forEach(s -> System.out.println(s));
        br.close();
        bw.close();
    }
}