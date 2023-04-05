import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        Integer[] N = new Integer[S.length()];
        for(int i = 0; i< S.length(); i++)
            N[i] = Integer.parseInt(S.substring(i,i+1));

        Arrays.sort(N, Collections.reverseOrder());

        for(int i = 0; i < N.length; i++) {
            bw.write(N[i] + "");
        }

        bw.flush();
        bw.close();
    }

}