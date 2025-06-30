import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {


        int[] arr = new int[3];

        arr[0] = read();
        arr[1] = read();
        arr[2] = read();

        Arrays.sort(arr);

        System.out.println(arr[1]);
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
