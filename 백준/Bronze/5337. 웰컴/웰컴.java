import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        System.out.println(".  .   .");
        System.out.println("|  | _ | _. _ ._ _  _");
        System.out.println("|/\\|(/.|(_.(_)[ | )(/.");
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