import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        
        Map<Integer, Integer> map = new HashMap<>();
        while(N-->0) {
            int a = read();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        System.out.println(map.getOrDefault(read(), 0));
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