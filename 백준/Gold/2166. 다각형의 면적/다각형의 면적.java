import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws Exception {
        int N  = read();

        long[][] arr = new long[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        long ans = 0;

        for(int i = 0; i < N-1; i++) {
                ans += ccw(arr[i], arr[i + 1]);
        }

        ans += ccw(arr[N-1], arr[0]);

        if(ans % 2 == 0) {
            System.out.println(Math.abs(ans / 2) + ".0");
        } else {
            System.out.println(Math.abs(ans / 2) + ".5");
        }
    }

    private static long ccw(long[] first, long[] end) {

        // 0 first[0] end[0]
        // 0 first[1] end[1]
        long ans = first[0] * end[1] - first[1] * end[0];

        return ans;
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