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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int tmp = Integer.parseInt(st.nextToken());
        int ans = 1;
        while(st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            if(tmp + 1 == i) ans = 1;
            else if(tmp - 1 == i) ans = 0;
            else {
                ans = -1;
                break;
            }
            tmp = i;
        }
        if(ans == 1) bw.write("ascending");
        else if(ans == 0) bw.write("descending");
        else bw.write("mixed");


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}