import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	//https://www.acmicpc.net/problem/24416
	
	//dp를 이용한 피보나치 수 출력
	public static int fibonacci(int n) {
		int[] fibos = new int[n+1];
		fibos[1]=fibos[2]=1;
		for(int i=3;i<=n;i++) {
			fibos[i]=fibos[i-1]+fibos[i-2];
		}
		return fibos[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		//코드 1은 1을 더한 횟수임으로 피보나치수와 동일
		//코드 2는 3~n만큼 반복이므로 n-2만큼 실행
		bw.append(fibonacci(n)+" "+(n-2));
		bw.close();
		br.close();
	}
}