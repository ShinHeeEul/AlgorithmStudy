import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    

    public static int gcd(int a, int b) {
        if(b== 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b=  Integer.parseInt(st.nextToken());
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int gcd = gcd(a,b);
        System.out.println(gcd);
        System.out.println(a * b / gcd);



    }

}