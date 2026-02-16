import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        String cw = "" + s1[0] + s1[1] + s2[1] + s2[0];
        cw += cw;
        String ccw = "" + s1[0] + s2[0] + s2[1] + s1[1];
        ccw += ccw;

        if(cw.contains("HEPC") || ccw.contains("HEPC")) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}