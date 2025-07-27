import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] failure;
    static int[][] program;
    static int N;
    static int K;
    static int M;


    public static void main(String[] args) throws Exception {
        N = read();
        K = read();

        failure = new int[N][];
        program = new int[N][];
        int minLen = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < N; i++) {
            M = read();
            failure[i] = new int[M];
            program[i] = new int[M];
            for(int j =  0; j < M; j++) {
                program[i][j] = read();
            }

            if(minLen > M) {
                minLen = M;
                minIndex = i;
            }
            failure(i, program[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < minLen; i++) {
            if(i < K) {
                queue.add(program[minIndex][i]);
                continue;
            }

            boolean b = true;
            Integer[] temp = new Integer[K];
            queue.toArray(temp);
            for(int j = 0; j < N; j++) {
                if(j == minIndex) continue;
                b = kmp(j, program[j], temp);
                if(!b) break;
            }
            if(b) {
                System.out.println("YES");
                return;
            }

            queue.poll();
            queue.add(program[minIndex][i]);
        }

        boolean b = true;
        Integer[] temp = new Integer[K];
        queue.toArray(temp);
        for(int j = 0; j < N; j++) {
            if(j == minIndex) continue;
            b = kmp(j, program[j], temp);
            if(!b) break;
        }
        if(b) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }

    private static void failure(int num, int[] arr) {

        int j = 0;
        for(int i = 1; i < K; i++) {
            while(j != 0 && arr[j] != arr[i]) j = failure[num][j-1];

            if(arr[i] == arr[j]) {
                j++;
                failure[num][i] = j;
            }
        }
    }

    private static boolean kmp(int num, int[] arr, Integer[] comp) {

        int j = 0;
        int rj = 0;
        for(int i = 0; i < arr.length; i++) {
            while(j != 0 && comp[j] != arr[i]) j = failure[num][j-1];
            while(rj != 0 && comp[K - 1 - rj] != arr[i]) rj = failure[num][rj-1];

            if(arr[i] == comp[j]) {
                j++;
                if(j == K) return true;
            }

            if(arr[i] == comp[K - 1- rj]) {
                rj++;
                if(rj == K) return true;
            }

        }
        return false;
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
