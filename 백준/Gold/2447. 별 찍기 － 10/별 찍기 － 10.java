import java.io.*;
import java.util.*;

public class Main {


    static int[][] arr;

    static int[] di = {-1,-1,-1,1,1,1,0,0};
    static int[] dj = {1,0,-1,1,0,-1,1,-1};
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        int N = read();
        arr = new int[N][N];
        int a = (int) Math.ceil(Math.log(N) / Math.log(3));
        backTracking(N / 2, N / 2, a);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]==1?'*':' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void backTracking(int i, int j, int depth) {
        if(depth == 1) {
            for(int k = 0; k < 8; k++) {
                arr[i + di[k]][j + dj[k]] = 1;
            }
            return;
        }

        int a = (int) Math.pow(3, depth - 1);
        for(int k = 0; k < 8; k++) {
            backTracking(i + di[k] * a, j + dj[k] * a, depth - 1);
        }
    }

    private static int read() throws IOException {
        int d, o = 0;
        boolean negative = false;

        while ((d = System.in.read()) <= 32);

        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        do {
            o = (o << 3) + (o << 1) + (d & 15); // o = o * 10 + (d - '0')
        } while ((d = System.in.read()) >= '0' && d <= '9');

        return negative ? -o : o;
    }
}