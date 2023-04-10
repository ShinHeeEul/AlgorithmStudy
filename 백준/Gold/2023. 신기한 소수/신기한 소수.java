import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        //2,3,5,7 추가하고 시작
        stack.push(7); stack.push(5);
        stack.push(3); stack.push(2);

        int h = (int) Math.pow(10, N);
        //arr = new boolean[h];
        //자릿수 N+1만큼 소수 구분해서 list에 넣어주기
        //arr[0] = true; arr[1] = true;
        //stack이 빌때까지 반복
        while(!stack.isEmpty()) {
            int a = stack.pop();
            //a가 해당 자릿값 숫자라면 출력
            if((a % (Math.pow(10, N-1))) != a) bw.write(a + "\n");
            a *= 10;
            for(int i = 9; i >= 0; i--) {
                int k = a + i;
                //소수이면 추가
                if((k < h) && Decimal(k)) stack.push(k);
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean Decimal(int k) {
        /*
        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
          if(arr[i]) continue;
          for(int j = i*i; j < arr.length; j+=i) arr[j] = true;
        }*/
        for(int i = 2; i <= k / 2; i++) {
            if(k % i == 0) return false;
        }
        return true;
    }

}