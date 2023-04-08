import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        //nlogn
        //현재 높이보다 높은 나무의 갯수
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (map.get(A[i]) == null) map.put(A[i], 1);
            else map.put(A[i], map.get(A[i])+1);
        }

        //count를 최소화 시키는게 목적
        //count가 제일 적으면서 합이 M이 되는 A[i]들
        //정렬 후 높은 애부터 내려가면서
        //나무 만나면 -> A[N-count-1]의 값이 i인 경우 count++;
        //가져갈 나무인 current는 current += count;
        //current가 M 이상이 될 때 현재 높이 i 출력

        //중복 처리
        //Map으로 저장?
        //값, 빈도수 형태로?
        int current = 0;
        Arrays.sort(A);
        
        for(int i = A[N-1]; i >= 0; i--) {
            current += count;
            if(current >= M) {
                bw.write(i + "");
                break;
            }
            if(N-count-1 < 0) continue;
            if (A[N - count - 1] == i) count += map.get(i);
        }
        bw.flush();
        bw.close();
    }

}