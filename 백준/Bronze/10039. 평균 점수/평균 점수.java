import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {

        int sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += Math.max(read(), 40);
        }

        System.out.println(sum / 5);
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
