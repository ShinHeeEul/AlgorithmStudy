public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int L = read();

        // 2h + 1 3h + 3 4h + 6
        // Lh + 1부터 (L-1)까지의 합 (i-1)i/2
        for(int i = L; i <= 100; i++) {
            double h = ((double) N - ((double) (i-1) * (double) i / 2.0)) / (double) i;

            if(h < 0) continue;

            //2000000000 2
            //3 2
            if(h == (long) h) {
                for(int j = 0; j < i; j++) {
                    System.out.print((long) h + j + " ");
                }
                return;
            }
        }
        System.out.println(-1);
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
