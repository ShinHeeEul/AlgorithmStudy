import java.util.*;
import java.io.*;

class Main {

	
	public static void main(String args[]) throws Exception {

		int N = read();
		int M = read();
		int C = read();
		
		int size = (int) Math.pow(2,N);
		
		int[] dp = new int[size];
		Arrays.fill(dp, Integer.MAX_VALUE >> 1);
		int[] arr = new int[N];
		// 0 1 2 3 4
		// 16 8 4 2 1
		// 11111
		dp[0] = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = read();
		}
		int max = 0;
		for(int i = 1; i < size; i++) {
			int val = 0;
			int index = 1;
			int tmp = i;
			int count = 0;

			
			while(tmp != 0) {
				if((tmp & 1) == 1) {
					if(index - 1 >= N) break;
					val += arr[index - 1];
					count++;
				}
				index++;
				tmp >>= 1;
			}
			
			if(val <= C) {
				dp[i] = 1;
				max = Math.max(count, max);
				continue;
			}
			
			// 부분 집합의 dp 두 개를 더하기
			// 모든 부분 집합 경우를 구해서 더해야 한다.
			for(int j = 1; j <= (i >> 1) ; j++) {
				if((i | j) == i) dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
			
			if(dp[i] <= M) max = Math.max(count, max);
			
			
		}
		System.out.println(max);
		
		
	}
	
	private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}