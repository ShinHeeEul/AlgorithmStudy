public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int K = read();

        int bNum = (N + 1) / 2;
        int aNum = N / 2;
        int max = bNum * aNum;
        
        if(K > max) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = bNum; i > 0; i--) {
            int t = K / i;
            sb.append("A".repeat(t));
            count += t;
            K %= i;
            sb.append("B");
        }
        
        sb.append("A".repeat(aNum - count));

        System.out.println(sb);


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
