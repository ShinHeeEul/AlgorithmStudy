class Main {

    public static void main(String[] args) throws Exception {
        int n = read();

        int[][] arr = new int[32][3];
        arr[0][0] = 1;
        for(int i = 0; i < 30; i++) {
            arr[i + 2][0] += arr[i][0];
            arr[i + 1][1] += arr[i][0] * 2;
            arr[i + 1][0] += arr[i][1];
            arr[i + 1][2] += arr[i][1];
            arr[i + 1][1] += arr[i][2];
        }
        System.out.println(arr[n][0]);
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