import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        //15 / 2 = 7 -> 654 54321
        //10 / 2 = 5 -> 4321
        //20 / 2 10 -> 123456
        //0 1 3 6 10 15 21 28 36..
        int size = N/2 + 2;
        //본인 먼저 취급
        int count = 1;
        //sum이 N보다 클 때, sum에서 start_index 값을 빼주고? start_index 증가 -> sum이 N보다 커지면 다음 값에서부터 N과 일치하는 것 있나 체크
        //sum > N sum = sum - start_index; start_index++
        //sum이 N보다 작을 때, end_index값을 늘려가면서 N 체크
        //sum < N end_index++; sum = sum + end_index;
        //sum == N일 경우 count 값을 올리고 end_index를 1늘리기
        // sum == N end_index++; sum = sum + end_index; count++;
        // 이상한데?? 체크`1
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        while(endIndex != N) {
            if(sum > N) {
                sum -= startIndex;
                startIndex++;
            }
            else if(sum < N) {
                endIndex++;
                sum += endIndex;
            }
            else {
                endIndex++;
                sum += endIndex;
                count++;
            }
        }

        System.out.println(count);
    }

}