import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =  Integer.parseInt(br.readLine());

        int sum = 0;
        int i;
        for(i = 1; sum < T; i++) {
            sum += i;
        }

        sum = sum - T + 1;
        if(i%2 == 0) {
            System.out.println( sum + "/" + (i-sum));
        }
        else{
            System.out.println((i-sum) + "/" + sum);
        }

    }

}