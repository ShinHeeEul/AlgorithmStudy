public class Main {


    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        int[] arr = new int[N + 1];
        while(M-->0) {
            int i = read();
            int j = read();
            int k = read();
            for(int a = i; a <= j; a++) {
                arr[a] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
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