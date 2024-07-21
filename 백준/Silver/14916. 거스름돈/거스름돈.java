public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int answer = 0;
        if(N == 3 || N == 1) {
            System.out.println(-1);
            return;
        }
        if((N % 5) % 2 == 0) {
            answer += (N / 5);
            N %= 5;
        } else {
            answer += (N / 5) - 1;
            N %= 5;
            N += 5;
        }
        answer += (N / 2);
        N %= 2;
        System.out.println(N == 0 ? answer : -1);
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
