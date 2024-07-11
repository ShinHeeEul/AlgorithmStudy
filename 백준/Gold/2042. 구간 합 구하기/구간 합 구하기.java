import java.io.FileInputStream;

public class Main {
	static int N, M, K;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		N = (int) read();
		M = (int) read();
		K = (int) read();
		tree = new long[N+1]; // 1 부터 인덱스로 사용
        StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			update(i, read());
		}
		
		for(int i = 0; i < M+K; i++) {
			int a = (int) read();
			
			if(a == 1) { // update
				int idx = (int) read();
				long val = read();
				long diff = val - sum(idx, idx);
				update(idx, diff);
			}
			else if (a == 2) { // sum
				int left = (int) read();
				int right = (int) read();
                sb.append(sum(left, right)).append("\n");
			}
		}
        System.out.println(sb);
	}

	private static void update(int i, long diff) { // i번째 값을 tree[i]+diff로 변경
		while(i < tree.length) {
			tree[i] += diff;
			i = i + (i & -i);
		}
	}
	
	private static long sum(int left, int right) { // left부터 right번째 까지의 구간합
		return sum(right) - sum(left-1);
	}
	
	private static long sum(int i) { // 1~i번째 까지의 구간합
		long answer = 0;
		while (i > 0) {
			answer += tree[i];
			i = i - (i & (-i));
		}
		return answer;
	}
    
    private static long read() throws Exception {
        long d, o;
        boolean negative = false;
        d = System.in.read();

        if (d == '-') {

            negative = true;
            d = System.in.read();
        }
        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}