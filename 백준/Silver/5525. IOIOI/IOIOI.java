import java.io.*;
import java.util.*;

class Main {

    static String s = "";
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String Pn = "I";
        for(int i = 0; i < N; i++) Pn += "OI";

        int count = 0;

        for(int i = 0; i < s.length()-(N*2); i++) {
            if(s.charAt(i) == 'I') {
                if(s.charAt(i + 1) != 'O') continue;
                if(s.charAt(i + 2) != 'I') continue;
                String tmp = s.substring(i, i + Pn.length());
                if(tmp.equals(Pn)) count++;
            }
        }

        System.out.println(count);
    }
}