import java.io.*;
import java.util.*;

public class Main {

    public static int[] A, tmp;
    public static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = new int[N+1];
        tmp = new int[N+1];

        for(int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        merget_sort(1,N);

        System.out.println(count);
        bw.flush();
        bw.close();
    }

    private static void merget_sort(int s, int e) {
        if(e-s < 1)
            return;

        int m = s + (e-s) / 2;

        //그룹 분할
        merget_sort(s,m);
        merget_sort(m+1,e);

        //그룹 다 분할 후, 해당 그룹을 돌면서 tmp에 값을 넣어줌
        for(int i = s; i <= e; i++) tmp[i] = A[i];

        int k = s;
        //앞 그룹 start_index
        int index1 = s;
        //뒷 그룹 start_index
        int index2 = m+1;
        //둘 다 최댓값이 정리하기 전까지
        while(index1 <= m && index2 <= e) {
            //그룹 내부 돌면서 작은 값을 A에 값 넣음
            if(tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                count += index2 - k;
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        // 둘중 하나가 최댓값에 도착했다면 나머지 값들 정리
        while(index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }

}