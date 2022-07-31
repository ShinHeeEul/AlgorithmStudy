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

        for(int i = 1; i < N + 1; i++) {
            for(int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }



        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}