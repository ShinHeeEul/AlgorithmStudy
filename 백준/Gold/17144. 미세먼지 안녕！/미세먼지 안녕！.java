import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int R;
    static int C;
    static int[] dc = {1, -1, 0 , 0};
    static int[] dr = {0 ,0, 1, -1};
    static ArrayList<Integer> airConditioner;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr = new int[R+2][C+2];
        airConditioner = new ArrayList<>();
        for(int i = 1; i <= R; i++) {
            Arrays.fill(arr[i], -2);
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) airConditioner.add(i);
            }
        }


        Arrays.fill(arr[R+1], -2);
        Arrays.fill(arr[0], -2);

        for(int i = 0; i < T; i++) {
            spread();
            leftWind();
            rightWind();
        }

        int sum = 0;
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                sum += arr[i][j];
            }
        }

        System.out.println(sum+2);

                

    }

    private static void spread() {
        int[][] tmp = new int[R+2][C+2];
        for(int i = 1; i <= R; i++) {
            tmp[i] = arr[i].clone();
        }
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                int count = 0;
                for(int k = 0; k < 4; k++) {
                    if((arr[i + dc[k]][j + dr[k]] == -2) || (arr[i + dc[k]][j + dr[k]] == -1)) continue;
                    count++;
                    tmp[i + dc[k]][j + dr[k]] += arr[i][j] / 5;
                }
                tmp[i][j] -= count * (arr[i][j] / 5);
            }
        }
        for(int i = 1; i <= R; i++) {
            arr[i] = tmp[i].clone();
        }
    }

    private static void leftWind() {
        int start = airConditioner.get(0);

        for(int i = start-2; i > 0; i--) {
            arr[i+1][1] = arr[i][1];
        }

        for(int i = 2; i <= C; i++) {
            arr[1][i-1] = arr[1][i];
        }

        for(int i = 2; i <= start; i++) {
            arr[i-1][C] = arr[i][C];
        }

        for(int i = C-1; i > 1; i--) {
            arr[start][i+1] = arr[start][i];
        }
        arr[start][2] = 0;
    }

    private static void rightWind() {
        int start = airConditioner.get(1);

        for(int i = start+2; i <= R; i++) {
            arr[i-1][1] = arr[i][1];
        }

        for(int i = 2; i <= C; i++) {
            arr[R][i-1] = arr[R][i];
        }

        for(int i = R-1; i >= start; i--) {
            arr[i+1][C] = arr[i][C];
        }

        for(int i = C-1; i > 1; i--) {
            arr[start][i+1] = arr[start][i];
        }
        arr[start][2] = 0;
    }



    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
