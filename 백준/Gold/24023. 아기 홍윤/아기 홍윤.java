
public class Main {
    public static void main(String[] args) throws Exception{
        long N = read();
        long K = read();
        long ans = 0L;
        int start = 1;
        for(int i = 1; i <= N; i++) {
            ans |= read();
            if((ans | K) != K) {
                start = i + 1;
                ans = 0L;
                continue;
            }
            if(ans == K) {
                System.out.println(start + " " + i);
                return;
            }
        }
        System.out.println(-1);
        }

    private static long read() throws Exception {
        long d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;

    }
}