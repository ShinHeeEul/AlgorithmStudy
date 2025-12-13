public class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[] sum = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + read();
        }

        StringBuilder sb = new StringBuilder();

        while(M --> 0) {
            int a = read();
            int b = read();
            sb.append(sum[b] - sum[a - 1]).append("\n");
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