
public class Main {
    public static void main(String[] args) throws Exception{
        int N = read();
        long K = read();
        long ans = 0;
        int start = 1;
        for(int i = 1; i <= N; i++) {
            long a = read();
            ans |= a;
            //자릿수가 같지 않으면? -> 크든, 같지 않든 K랑 연산하면 뭔가 다른 값이 나오겠지?
            //그러면 그 수 제외하고 계산
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

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;

    }
}