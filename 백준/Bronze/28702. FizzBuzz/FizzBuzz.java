import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = new String[3];

        s[0] = br.readLine();
        s[1] = br.readLine();
        s[2] = br.readLine();

        int N = 0;
        int index = 0;
        for(int i = 0; i < 3; i++) {
            if(s[i].charAt(0) <= '9') {
                index = i;
                N = Integer.parseInt(s[i]);
            }
        }

        int ans = N + (3 - index);

        if(ans % 3 == 0 && ans % 5 == 0) {
            System.out.println("FizzBuzz");

        } else if(ans % 3 == 0) {
            System.out.println("Fizz");
        } else if(ans % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(ans);
        }
    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}