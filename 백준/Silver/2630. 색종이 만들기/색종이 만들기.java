import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle(N, 0, N - 1, 0, N-1);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void cycle(int N, int i_start, int i_end,
                              int j_start, int j_end) {
        boolean isEnd = true;
        int color = map[i_start][j_start];

        for (int i = i_start; i <= i_end; i++) {
            for (int j = j_start; j <= j_end; j++) {
                if (color != map[i][j]) {
                    isEnd = false;
                    break;
                }
            }
            if (!isEnd) break;
        }
        if (isEnd) {
            if (color == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        //다음 분석 요청
        cycle(N / 2, i_start, i_start + N / 2 - 1, j_start, j_start + N / 2 - 1);
        cycle(N / 2, i_start, i_start + N/2 - 1, j_start + N/2, j_start + N-1);
        cycle(N / 2, i_start + N/2, i_start + N -1, j_start, j_start + N/2 - 1);
        cycle(N / 2, i_start + N / 2, i_start + N - 1, j_start + N/2, j_start + N-1);
    }

}