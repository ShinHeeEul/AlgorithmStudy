import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {

        int N = read();
        StringBuilder sb = new StringBuilder();
        int star = 1;
        for(int i = 1; i < (N * 2); i++) {

            int blank = Math.abs(N - i);
            // 0 : 1
            // 1 : 3
            // 2 : 5
            while(blank --> 0) sb.append(" ");
            sb.append("*".repeat(Math.max(star, 0)));
            sb.append("\n");
            if(i < N) star += 2;
            else star -= 2;
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
