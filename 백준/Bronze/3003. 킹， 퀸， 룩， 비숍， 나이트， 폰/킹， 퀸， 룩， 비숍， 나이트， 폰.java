import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            int a = Integer.parseInt(st.nextToken());
            if((i <= 1)) bw.write((1-a)+" ");
            else if(i <= 4) bw.write((2-a)+ " ");
            else bw.write((8-a)+" ");
        }



        bw.flush();
        br.close();
        bw.close();
    }
}