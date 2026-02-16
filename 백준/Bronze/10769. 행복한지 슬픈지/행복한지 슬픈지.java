import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cnt = 0;
        int happy = 0;
        int sad = 0;
        for(char c : s.toCharArray()) {

            if(cnt == 0 && c == ':') {
                cnt++;
            }
            else if(cnt == 1 && c == '-') {
                cnt++;
            } else {
                if(cnt == 2 && c == '(') sad++;
                else if(cnt == 2 && c == ')') happy++;
                cnt = 0;
            }
        }
        if(happy == 0 && sad == 0) System.out.println("none");
        else if(happy == sad) System.out.println("unsure");
        else if(happy > sad) System.out.println("happy");
        else System.out.println("sad");
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