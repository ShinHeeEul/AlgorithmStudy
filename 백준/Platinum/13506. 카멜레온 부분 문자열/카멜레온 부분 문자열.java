import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] failure;
    static int[] failure2;
    static boolean[] b;
    static int N;
    static String S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        N = S.length();

        failure = new int[N];
        failure2 = new int[N];
        b = new boolean[N];

        failure();

        if(failure2[N - 1] == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(S.substring(0, failure2[N- 1]));
    }

    public static void failure() {
        int j = 0;
        char[] s1 = S.toCharArray();

        for(int i = 1; i < N; i++) {

            while(j != 0 && s1[i] != s1[j]) j = failure[j - 1];

            if(s1[i] == s1[j]) {
                failure[i] = ++j;

                if(b[j]) {
                    failure2[i] = j;
                } else {
                    b[j] = true;
                    failure2[i] = failure[j-1];
                }

            }
        }
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
