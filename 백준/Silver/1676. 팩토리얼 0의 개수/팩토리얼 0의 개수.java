class Main {

    public static void main(String[] args) throws Exception {
        int N = read();

        int two = 0;
        int five = 0;

        for(int i = 1; i <= N; i++) {
            int a = i;
            while(a % 2 == 0) {
                if(a == 0) break;
                two++;
                a /= 2;
            }
            while(a % 5 == 0) {
                if(a == 0) break;
                five++;
                a /= 5;
            }
        }
            System.out.println(Math.min(two, five));
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