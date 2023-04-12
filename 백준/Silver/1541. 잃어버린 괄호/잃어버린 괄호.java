import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st= new StringTokenizer(br.readLine(), "-");
        int pSum = 0;
        StringTokenizer pst = new StringTokenizer(st.nextToken(), "+");
        while(pst.hasMoreTokens()) pSum += Integer.parseInt(pst.nextToken());
        int sum = pSum;
        while(st.hasMoreTokens()) {
            pSum = 0;
            pst = new StringTokenizer(st.nextToken(), "+");
            while(pst.hasMoreTokens()) pSum += Integer.parseInt(pst.nextToken());
            sum -= pSum;
        }


        System.out.println(sum);

    }
}