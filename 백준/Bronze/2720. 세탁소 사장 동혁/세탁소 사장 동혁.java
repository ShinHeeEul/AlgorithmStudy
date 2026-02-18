import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int T = read();

        while(T-->0) {
            int q = 0;
            int d = 0;
            int n = 0;
            int p = 0;
            int N = read();
            q += (N / 25);
            N %= 25;
            d += (N / 10);
            N %= 10;
            n += (N / 5);
            N %= 5;
            p += N;
            System.out.println(q + " " + d + " " + n + " " + p);
        }

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