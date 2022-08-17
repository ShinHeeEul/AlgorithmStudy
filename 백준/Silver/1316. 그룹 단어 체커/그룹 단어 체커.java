import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        int sum = 0;


        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            String list = "";
            boolean check = true;
            for(int j = 0; j < S.length();) {
                char c = S.charAt(j);
                if(!list.contains(c+"")) {
                    list += c;
                    while((j < S.length()) && (c == S.charAt(j))) j++;
                }
                else {
                    check = false;
                    break;
                }
            }
            if(check) sum++;
        }

        bw.write(sum + "");

        bw.flush();
        br.close();
        bw.close();
    }
}