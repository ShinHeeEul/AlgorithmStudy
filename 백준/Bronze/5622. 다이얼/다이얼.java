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

        String S = br.readLine();

        int sum = 0;
        for(int i = 0; i < S.length(); i++) {
            int val = S.charAt(i) - 'A';
            if(val < 3) sum += 3;
            else if(val < 6) sum += 4;
            else if(val < 9) sum += 5;
            else if(val < 12) sum += 6;
            else if(val < 15) sum += 7;
            else if(val < 19) sum += 8;
            else if(val < 22) sum += 9;
            else sum += 10;
        }

        System.out.println(sum);


        bw.flush();
        br.close();
        bw.close();
    }
}