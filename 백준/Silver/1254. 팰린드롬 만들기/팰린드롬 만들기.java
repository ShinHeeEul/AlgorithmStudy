import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static String s, t;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        //앞에서 부터 n개 제외하고 펠린드롬이면?
        //length + n 이 정답인듯..?
        for(int i = 0; i < length; i++) {
            String ss = s.substring(i, length);
            if(isPellin(ss)) {
                System.out.println(length + i);
                return;
            }
        }
        System.out.println(length * 2);
    }

    public static boolean isPellin(String s) {
        int length = s.length();

        for(int i = 0; i < (int) length / 2; i++) {
            char start = s.charAt(i);
            char end = s.charAt(length - i - 1);
            if(start != end) return false;
        }
        return true;
    }
}