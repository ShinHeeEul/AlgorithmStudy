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


        String line = "";

        while(!(line = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a + b + "\n");
        }

        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}