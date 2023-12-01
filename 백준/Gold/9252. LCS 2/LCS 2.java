import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        //LCS
        int[][] arr = new int[s1.length()+1][s2.length()+1];
        boolean[] bi = new boolean[s1.length()];
        String answer = "";
        int check = 0;
        for(int i = 0; i < s1.length(); i++) {
            char ci = s1.charAt(i);
            for(int j = 0; j < s2.length(); j++) {
                char cj = s2.charAt(j);

                if(ci == cj) {
                    arr[i+1][j+1] = arr[i][j] + 1;
                    continue;
                }
                arr[i+1][j+1] = Math.max(arr[i+1][j], arr[i][j+1]);
            }
        }

        int i = s1.length();
        int j = s2.length();
        while((i != 0) && (j != 0)) {

            if(arr[i][j] == arr[i-1][j]) {
                i -= 1;
                continue;
            } else if(arr[i][j] == arr[i][j-1]) {
                j -= 1;
                continue;
            }
            answer = s1.charAt(i-1) + answer;
            i -= 1;
            j -= 1;
        }
        System.out.println(arr[s1.length()][s2.length()]);
        System.out.println(answer);
        //dp 2차원 배열로
        // 일치하는 놈이 나오면
        // arr[i-1][j-1] + 1로 업데이트하고
        // 일치하지 않는 놈이 나온다면
        // arr[i-1][j] arr[i][j-1] 중 큰 놈으로 업데이트

        /**
         *      A C A Y K P
         *  C   0 1 1 1 1 1
         *  A   1 1 2 2 2 2
         *  P   1 1 2 2 2 3
         *  C   1 2 2 2 2 3
         *  A   2 2 3 3 3 3
         *  K   2 2 3 3 4 4
         */
    }
}
