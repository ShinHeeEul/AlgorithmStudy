import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while(t.length() > s.length()) {

            char c = t.charAt(t.length()-1);
            if(c == 'B') {
                t = t.deleteCharAt(t.length()-1).reverse();
            } else if(c == 'A') {
                t = t.deleteCharAt(t.length()-1);
            }
        }

        if(s.contentEquals(t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
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