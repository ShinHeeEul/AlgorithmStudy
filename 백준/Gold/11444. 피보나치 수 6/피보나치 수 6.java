import java.util.HashMap;

class Main {

    static long MOD = 1_000_000_007L;
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws Exception {

        long N = read();
        map.put(0L, 0L);
        map.put(1L, 1L);
        map.put(2L, 2L);
        System.out.println(fpow(N));

    }

    public static long fpow(long N) {

        if(N == 0) return 0;
        if(N == 1) return 1;
        if(N == 2) return 1;
        if(map.getOrDefault(N, 0L) != 0L) return map.get(N);

        long a;
        long b;
        if(N % 2 == 0) {
            long m = N/2;
            a = fpow(m - 1);
            b = fpow(m);
            long ans = (2L * a + b) * b;
            map.put(N, ans % MOD);
        }
        else{
            long m = (N + 1) / 2;
            a = fpow(m);
            b = fpow(m - 1);
            long ans = (a * a + b * b);
            map.put(N, ans % MOD);
        }
        return map.get(N);
    }


    private static long read() throws Exception {
        long d, o;
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