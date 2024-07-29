import java.util.HashMap;

class Main {

    public static void main(String[] args) throws Exception {

        int A = read();
        int B = read();
        int C = read();

        System.out.println(A + B - C);
        StringBuilder sb = new StringBuilder();
        sb.append(A).append(B);
        int sum = Integer.parseInt(sb.toString());
        System.out.println(sum - C);
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