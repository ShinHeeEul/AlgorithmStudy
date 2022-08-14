import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        String S = br.readLine();

        while(!S.equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(S, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(((Math.pow(a,2) + Math.pow(b,2)) == Math.pow(c,2))
                    ||((Math.pow(a,2) + Math.pow(c,2)) == Math.pow(b,2))
                    ||((Math.pow(c,2) + Math.pow(b,2)) == Math.pow(a,2))) bw.write("right" + "\n");
            else bw.write("wrong" + "\n");

            S = br.readLine();
        }



        bw.flush();
        br.close();
        bw.close();
    }
}