import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+2][N+2];
        HashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap();
        Arrays.fill(arr[0], -1);
        Arrays.fill(arr[N+1], -1);
        for(int i = 0 ; i < N+2; i++) {
            arr[i][0] = -1;
            arr[i][N+1] = -1;
        }

        for(int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            ArrayList<Integer> b = new ArrayList<>();

            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));

            map.put(a, b);
        }
        int sum = 0;
        for(int key : map.keySet()) {
            ArrayList<Integer> b = map.get(key);
            int max = 0;
            int maxi = 0;
            int maxj = 0;

            for(int i = N; i > 0; i--) {
                for(int j = N; j > 0; j--) {
                    int answer = check(i, j, b);
                    if(max <= answer) {
                        maxi = i;
                        maxj = j;
                        max = answer;
                    }
                }
            }
            arr[maxi][maxj] = key;
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                ArrayList<Integer> b = map.get(arr[i][j]);
                int tmp = 0;
                if(b.contains(arr[i+1][j])) {
                    tmp++;
                }if(b.contains(arr[i-1][j])) {
                    tmp++;
                }if(b.contains(arr[i][j+1])) {
                    tmp++;
                }if(b.contains(arr[i][j-1])) {
                    tmp++;
                }
                if(tmp == 1) {
                    sum += 1;
                } else if(tmp == 2) {
                    sum += 10;
                } else if(tmp == 3) {
                    sum += 100;
                } else if(tmp == 4) {
                    sum += 1000;
                }
            }
        }

        System.out.println(sum);
    }

    public static int check( int i, int j, ArrayList<Integer> b) {
        if(arr[i][j] != 0) {
            return -1;
        }
        int sum = 0;
        if((arr[i+1][j] == 0)) {
            sum++;
        }
        if((arr[i-1][j] == 0)) {
            sum++;
        }
        if((arr[i][j-1] == 0)) {
            sum++;
        }
        if((arr[i][j+1] == 0)) {
            sum++;
        }
        if(b.contains(arr[i+1][j])) {
            sum+=10;
        }if(b.contains(arr[i-1][j])) {
            sum+=10;
        }if(b.contains(arr[i][j+1])) {
            sum+=10;
        }if(b.contains(arr[i][j-1])) {
            sum+=10;
        }

        return sum;
    }
}