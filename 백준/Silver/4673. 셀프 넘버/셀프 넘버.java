import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;


public class Main {

    public static int d(int a) {
        String ans = "";
        int max = (45>a)?a:45;
        for(int i = 0; i < max; i++) {
            int cons = a-i;
            String S = Integer.toString(cons);
            for(int j = 0; j < S.length(); j++) {
                cons += Integer.parseInt(S.charAt(j) + "");
            }
            if (cons == a) {
                return -1;
            }
        }
        return a;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        for(int i = 1; i < 10000; i++) {
            int a = d(i);
            if(a == -1) continue;
            System.out.println(a);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}