import java.io.*;
import java.util.*;

public class Main {

    static int[] weight;
    static boolean[] visited;
    static int N;
    static int M;
    static int K;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] arr = new int[s1.length()+1][s2.length()+1];

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        System.out.println(arr[s1.length()][s2.length()]);
    }
}
