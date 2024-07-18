public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int ans = 1;

        int[][] box = new int[N + 1][M + 1];
        boolean b = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int a = System.in.read() - 48;
                if (a == 1) b = true;
                box[i][j] = a;
                if (box[i - 1][j] >= 1 && box[i][j - 1] >= 1 && box[i - 1][j - 1] >= 1 && box[i][j] >= 1) {
                    box[i][j] = Math.min(box[i][j - 1], Math.min(box[i - 1][j], box[i - 1][j - 1])) + 1;
                }
                ans = Math.max(ans, box[i][j]);
            }
            System.in.read();
        }
        System.out.print(b ? ans * ans : 0);


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
