import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        long fac = 1;

        for(int i = 2; i <= N; i++) fac *= i;

        System.out.println(fac);
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