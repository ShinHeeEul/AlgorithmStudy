import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] b = new boolean[30];
        for(int i = 0; i < 28; i++) {
            int N = Integer.parseInt(br.readLine());
            b[N-1] = true;
        }
        for(int i = 0; i < 30; i++) {
            if(!b[i]) System.out.println(i+1);
        }
    }
}