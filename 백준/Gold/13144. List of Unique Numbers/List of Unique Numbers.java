import java.util.BitSet;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N+1];
        long cnt = 0;
        BitSet check = new BitSet(100001);
        
        for (int i = 1; i <= N; i++) arr[i] = read();

        for(int start=1, end=0; start <= N; start++) {
            while(end+1<=N && !check.get(arr[end+1])) {
                end++;
                check.set(arr[end]);
            }
            cnt += end-start+1;
            check.set(arr[start], false);
        }

        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
