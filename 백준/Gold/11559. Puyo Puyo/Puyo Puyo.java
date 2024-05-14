import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static Character[][] cols = new Character[14][8];
    static boolean[][] visited = new boolean[14][8];
    static HashSet<int[]> set = new HashSet<>();
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(cols[0], '.');
        Arrays.fill(cols[13], '.');
        for(int k = 1; k <= 12; k++) {
            Arrays.fill(cols[k], '.');
            String s = br.readLine();
            for (int i = 1; i <= 6; i++) {
                cols[k][i] = s.charAt(i-1);
            }
        }


        boolean b = true;
        int T = -1;
        while(b) {
            T++;
            b = false;
            // 4개 pop
            for(int j = 6; j > 0; j--) {
                for(int i = 12; i > 0; i--) {
                    if(cols[i][j] == '.') continue;
                    char c = cols[i][j];
                    visited = new boolean[14][8];
                    count = 0;
                    set = new HashSet<>();
                    dfs(i, j, c);

                    if(count >= 4) {
                        for(int[] tl : set) {
                            cols[tl[0]][tl[1]] = '.';
                        }
                        b = true;
                    }
                }
            }
            // 내리기
            for(int j = 1; j <= 6; j++) {
                int index = 12;
                Character[] tmp = new Character[14];
                Arrays.fill(tmp, '.');
                for(int i = 12; i > 0; i--) {
                    if(cols[i][j] == '.') continue;
                    tmp[index] = cols[i][j];
                    index--;
                }
                for(int i = 12; i > 0 ; i--) {
                    cols[i][j] = tmp[i];
                }
            }
        }

        System.out.println(T);

    }

    public static void dfs(int i, int j, char c) {

        set.add(new int[] {i,j});

        if(!visited[i+1][j] && cols[i+1][j] == c) {
            visited[i+1][j] = true;
            count++;
           dfs(i+1, j, c);
        }
        if(!visited[i][j+1] && cols[i][j+1] == c) {
            visited[i][j+1] = true;
            count++;
             dfs(i, j+1, c);
        }

        if(!visited[i-1][j] && cols[i-1][j] == c) {
            visited[i-1][j] = true;
            count++;
            dfs(i-1, j, c);
        }
        if(!visited[i][j-1] && cols[i][j-1] == c) {
            visited[i][j-1] = true;
            count++;
            dfs(i, j-1, c);
        }

    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
