class Main {

    public static void main(String[] args) throws Exception {
        int N = read();

        int[] size = new int[6];

        for(int i = 0; i < size.length; i++) {
            size[i] = read();
        }

        int T = read();
        int P = read();

        int a = 6;

        for (int j : size) {
            if(j == 0) a--;
            else a += (j - 1) / T;
        }

        System.out.println(a);
        System.out.println(N / P + " " + N % P);
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