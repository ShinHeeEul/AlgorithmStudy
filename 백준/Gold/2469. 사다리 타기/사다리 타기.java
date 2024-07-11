import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static char[][] ladder;
    static Character[] result;
    static Character[] start;
    static int K;
    static int N;
    static Character[] answer;
    static int line;
    public static void main(String[] args) throws Exception {

        K = read();
        N = read();

        ladder = new char[N][K-1];
        result = new Character[K];
        start = new Character[K];
        answer = new Character[K-1];

        for(int i = 0; i < K ; i++) {
            result[i] = (char) System.in.read();
            start[i] = (char) ('A' + i);
        }

        System.in.read();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K-1; j++) {
                ladder[i][j] = (char) System.in.read();

            }

            if(ladder[i][0] == '?') line = i;
            System.in.read();
        }

        if(backTracking(0, false)) {
            for(int i = 0; i< K-1; i++) {
                System.out.print(answer[i]);
            }
        } else {
            for(int i = 0; i < K-1; i++) {
                System.out.print('x');
            }
        }
    }


    private static boolean backTracking(int count, boolean b) {
        if(count == K-1) {
            return isSuccess();
        }
        answer[count] = '*';
        ladder[line][count] = '*';
         if(backTracking(count + 1, false)) return true;
         if(!b) {
             answer[count] = '-';
             ladder[line][count] = '-';
             return backTracking(count + 1, true);
         }
         return false;
    }

    private static boolean isSuccess() {
        for(int i = 0; i < K; i++) {
            if(down(i,0) != start[i]) {
                return false;
            }
        }
        return true;
    }


    private static char down(int i, int count) {
        if(count == N) {
            return result[i];
        }

        char c;
        if(i == 0) {
            if(ladder[count][0] == '*') {
                c = down(i, count + 1);
            } else {
                c = down(i + 1, count + 1);
            }
        } else if(i == K-1) {
            if(ladder[count][K-2] == '*') {
                c = down(i, count + 1);
            } else {
                c = down(i - 1, count + 1);
            }
        } else {
            if(ladder[count][i-1] == '-') {
                c = down(i -1, count + 1);
            } else if(ladder[count][i] == '-') {
                c = down(i + 1, count + 1);
            } else {
                c = down(i, count + 1);
            }
        }
        return c;
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
