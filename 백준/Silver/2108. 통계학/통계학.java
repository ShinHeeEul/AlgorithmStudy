import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int sum = 0;
        int[] tmp = new int[8001];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
            sum += A[i];
            tmp[4000 + A[i]]++;
        }
        int max = 0;
        int tmpp = 0;
        int[] tmppp = Arrays.copyOf(tmp, 8001);
        for(int i = 0; i < 8001; i++) {
            if(tmpp < tmp[i]){
                tmpp = tmp[i];
                max = i;
            }
        }
        Arrays.sort(A);
        Arrays.sort(tmp);
        //평균
        System.out.println(Math.round((float) sum / N));
        //중앙값
        System.out.println(A[N/2]);
        //최빈값
        if(tmp[8000] == tmp[7999]) {
            boolean check = false;
            //최빈값 중 두번쨰로 작은 값 출력
            for(int i = 0; i < 8001; i++) {
                if(tmppp[i] == tmpp){
                    if(!check) check = true;
                    else {
                        System.out.println(i - 4000);
                        break;
                    }
                }
            }
        }
        else {
            System.out.println(max-4000);
        }

        //범위
        System.out.println(A[N-1] - A[0]);

        bw.flush();
        bw.close();
    }

}