import java.util.Arrays;

public class Main {

    static int[] boxes;
    static int[][] rules;

    public static void main(String[] args) throws Exception {
        int N = read();
        int K = read();
        int D = read();

        boxes = new int[N];
        rules = new int[K][3];

        for(int i = 0; i < K; i++) {
            rules[i][0] = read();
            rules[i][1] = read();
            rules[i][2] = read();
        }

        int start = 0;
        int end = N;

        while(start < end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for(int i = 0; i < K; i++) {
                int[] rule = rules[i];
                int rule0 = rule[0];
                if(rule0 <= mid ) {
                    sum += (Math.min(mid, rule[1]) - rule0) / rule[2] + 1;
                }
            }
            if(sum >= D) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        System.out.println(end);
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
