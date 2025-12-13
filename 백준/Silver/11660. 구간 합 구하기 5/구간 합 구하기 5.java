public class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[][] arr = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = arr[i][j-1] + read();
            }
        }


        StringBuilder sb = new StringBuilder();

        while(M --> 0) {
            int sum = 0;

            int y1 = read();
            int x1 = read();
            int y2 = read();
            int x2 = read();

            for(int i = y1; i <= y2; i++) {
                sum += arr[i][x2] - arr[i][x1 - 1];
            }
            sb.append(sum).append("\n");
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