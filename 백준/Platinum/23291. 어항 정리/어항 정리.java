import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int K;
    static int[][] arr;

    static int[] di = {1, -1, 0 , 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
         N = read();
         K = read();

         arr = new int[N][N];

         for(int i = 0;i < N; i++) arr[0][i] = read();

         int cnt = 0;

         while(true) {
             sort();
             int min = Integer.MAX_VALUE;
             int max = 0;
             for(int i = 0; i < N; i++) {
                 min = Math.min(min, arr[0][i]);
                 max = Math.max(max, arr[0][i]);
             }
             cnt++;
             if(max - min <= K) break;
         }

        System.out.println(cnt);
     }

     public static void sort() {
        firstJob();
        secondJob();
     }

     public static void firstJob() {
        // 1. 가장 적은 물고기 파트에 한마리씩 넣기
         int min = Integer.MAX_VALUE;
         for(int i = 0; i < N; i++) min = Math.min(min, arr[0][i]);

         for(int i = 0; i < N; i++) if(min == arr[0][i]) arr[0][i]++;

         // 2. 공중 부양 시킨 뒤 바닥 없을 때까지 계속 접기

         // 1 2 2 3 3 4 4 5 5 6 6

         int cnt = 2;
         int cur = 1;
         magic(0);

         for(int i = 2; cur + i < N; i++) {
             magic(cur);
             cur += i;
             if(cur + i >= N) break;
             magic(cur);
             cur += i;
         }

         // 3. 물고기 재배치 시키고 일렬로 다시 펴기
         reLocationFish();
         reLocationTank();
     }

     // start 위치부터 0이 될때까지 가면서 쌓기
     public static void magic(int start) {

        for(int i = 0; i < N; i++) {
            if(arr[i][start] == 0) return;

            for(int j = start, k = 1; j >= 0; j--, k++) {
                if(arr[i][j] == 0) break;

                arr[k][start + 1 + i] = arr[i][j];
                arr[i][j] = 0;
            }
        }

     }

     public static void reLocationFish() {
        int[][] tmp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 0) continue;
                for(int k = 0; k < 4; k++) {
                    int ii = i + di[k];
                    int jj = j + dj[k];
                    if(ii < 0 || ii >= N || jj < 0 || jj >= N || arr[ii][jj] == 0) continue;
                    int diff = Math.abs(arr[ii][jj] - arr[i][j]) / 5;
                    // 더 큰 애 배치
                    if(arr[ii][jj] > arr[i][j]) {
                        tmp[ii][jj] -= diff;
                        tmp[i][j] += diff;
                    } else {
                        tmp[ii][jj] += diff;
                        tmp[i][j] -= diff;
                    }
                }

            }
        }

        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) arr[i][j] += (tmp[i][j] >> 1);
     }

     public static void reLocationTank() {
        int[] tmp = new int[N];

        int s = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[j][i] != 0) tmp[s++] = arr[j][i];
                else break;
            }
        }
        arr = new int[N][N];

        for(int i = 0; i < N; i++) arr[0][i] = tmp[i];
     }

     public static void secondJob() {
        // 1. 반씩 두번 접기

         int k = 0;
         int start = N / 4 * 3;
         int end = N - 1;
         for(int i = end; i >= start; i--) {
             arr[1][i] = arr[0][k];
             arr[0][k] = 0;
             k++;
         }
         for(int i = start; i <= end; i++) {
             arr[2][i] = arr[0][k];
             arr[0][k] = 0;
             k++;
         }
         for(int i = end; i >= start; i--) {
             arr[3][i] = arr[0][k];
             arr[0][k] = 0;
             k++;
         }
         // 2. 물고기 재배치 및 어항 재배치
         reLocationFish();
         reLocationTank();
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
