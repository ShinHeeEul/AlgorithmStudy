public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        long start = 0;
        long end = Integer.MAX_VALUE;
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++) {
            arr[i] = read();
            if(end > arr[i]) end = arr[i];
        }
        end *= M;

        while(start < end) {
            long mid = (start + end) / 2;
            long ans = 0;
            for(int i : arr) ans += mid/i;

            if(ans < M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);

    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
