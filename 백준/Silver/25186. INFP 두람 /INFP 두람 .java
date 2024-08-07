class Main {

    public static void main(String[] args) throws Exception {
        int N = read();

        double sum = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            int a = read();
            sum += a;
            arr[i] = a;
        }

        if(sum == 1) {
            System.out.println("Happy");
            return;
        }
        
        sum = (sum + 1) / 2;


        for(int i = 0; i < N; i++) {
            if(sum <= arr[i]) {
                System.out.println("Unhappy");
                return;
            }
        }
        System.out.println("Happy");
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