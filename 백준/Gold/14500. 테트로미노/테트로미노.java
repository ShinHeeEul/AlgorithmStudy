import java.io.*;
import java.util.*;

public class Main {

    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 일자
                if((j + 3) < M) {
                    check(arr[i][j]+ arr[i][j+1] + arr[i][j+2] + arr[i][j+3]);
                }
                if((i + 3) < N) {
                    check(arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j]);
                }
                // 정사각형
                if((i + 1) < N && (j + 1) < M) {
                    check(arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1]);
                }

                //기억
                if((i + 2) < N && (j + 1) < M) {
                    check(arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j]);
                    check(arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1]);
                    check(arr[i][j] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i][j+1]);
                    check(arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+2][j]);
                }
                if((i+1) < N && (j+2) < M) {
                    check(arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2]);
                    check(arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2]);
                    check(arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2]);
                    check(arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2]+ arr[i][j+2]);
                }
                //제트 & 뻐큐
                if((i + 2) < N && (j+1) < M) {
                    check(arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1]);
                    check(arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j] + arr[i+2][j]);

                    check(arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+1][j]);
                    check(arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1]);
                }
                if((i + 1) < N && (j + 2) < M) {
                    check(arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2]);
                    check(arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i][j+2]);

                    check(arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+1]);
                    check(arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]);
                }
            }
        }
        System.out.println(max);
    }

    static void check(int num) {
        if(max < num) {
            max = num;
        }
    }
}