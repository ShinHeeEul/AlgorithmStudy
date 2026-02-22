import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력값을 정수로 변환
        String input = br.readLine();
        if (input == null || input.isEmpty()) return;
        
        int N = Integer.parseInt(input);
        
        // 즐거움의 총합 계산
        // 공식: N * (N - 1) / 2
        // N이 최대 10이므로 int 범위 내에서 충분히 계산 가능합니다.
        int maxPleasure = (N * (N - 1)) / 2;
        
        // 결과 출력
        System.out.println(maxPleasure);
    }
}