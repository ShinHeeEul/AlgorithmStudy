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
            String tmp = "" + s.charAt(i);
            if(tmp.equals("I")) {
                for(int j = i+1; j < i + Pn.length(); j++)
                    tmp += s.charAt(j);
                //System.out.println(tmp);
                if(tmp.equals(Pn)) count++;
            }

        }

        System.out.println(count);
    }
}