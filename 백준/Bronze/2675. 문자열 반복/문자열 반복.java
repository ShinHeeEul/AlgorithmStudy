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

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            char[] ch = st.nextToken().toCharArray();
            for(int k = 0; k < ch.length;k++){
                for(int j = 0; j < R; j++) bw.write(ch[k] + "");
            }
            bw.write("\n");
        }


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}