import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {

        int N = read();
        StringBuilder sb = new StringBuilder();
        for(int i = N; i > 0; i--) {
            for(int j = 0; j < i; j++) sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb);
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
