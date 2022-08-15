import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;


public class Main {

    public static int d(String S) {

        for(int i = 0; i < S.length()-1; i++) {
            if(S.length() == 1) break;
            else {
                int dif = Integer.parseInt(S.charAt(1) + "")
                        - Integer.parseInt(S.charAt(0) + "");

                int tmp = Integer.parseInt(S.charAt(i+1) + "")
                        - Integer.parseInt(S.charAt(i) + "");
                if(dif != tmp) return -1;
            }
        }
        return Integer.parseInt(S);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i =1; i <= N; i++){
            int a = d(Integer.toString(i));
            if(a != -1) sum += 1;
        }

        System.out.println(sum);
        bw.flush();
        br.close();
        bw.close();
    }
}