import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int sum = 0;
        for(int i = 0; i < N;i++) {
            int a = Character.getNumericValue(S[i]);
            sum += a;
        }

        bw.write(sum + "\n");


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}