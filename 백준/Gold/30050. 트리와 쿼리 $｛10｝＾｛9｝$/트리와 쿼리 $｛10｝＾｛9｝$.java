import java.util.*;
import java.io.*;

public class Main {
	
	static Map<Integer, List<Integer>> down = new HashMap<>();
	static Map<Integer, Integer> up = new HashMap<>();
	static Map<Integer, Long> visited;
	public static void main(String[] args) throws Exception {
		// a랑 b 연결 해
		// a에서 b가는거 하나 추가하고, 원래 있던 거 끊고 b에서 a가는거추가해
		
		// 그리고 가는 점은 그냥 bfs 때려 이게 맘 편해=
		
		int Q = read();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			int n = read();
			int a = read();
			int b = read();
			
			if(n == 1) {
				// b to a
					// 부모랑 연 끊고
				int parent = up.getOrDefault(b, b >> 1);
				List<Integer> list = down.getOrDefault(parent,  new ArrayList<>(Arrays.asList(parent << 1, (parent << 1) + 1)));
				list.remove((Integer) b);
				up.put(b, a);
				// a to b
				list = down.getOrDefault(a, new ArrayList<>(Arrays.asList(a << 1, (a << 1) + 1)));
				list.add(b);
				down.put(a, list);
			} else {
				visited = new HashMap<>();
				visited.put(a, (long) a);
				goParent(a, 0);
				sb.append(findAnswer(b)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void goParent(int current, long sum) {
		if(current == 1) {
			visited.put(current, sum + 1);
			return;
		}
		
		visited.put(current, sum + current);
		
		goParent(up.getOrDefault(current, current >> 1), sum + current);
	}
	
	public static long findAnswer(int current) {
		
		if(visited.getOrDefault(current, 0L) != 0) return visited.get(current);
		
		return current + findAnswer(up.getOrDefault(current,current >> 1));
	}

	
	public static class Node {
		int val;
		int sum;
		public Node(int val, int sum) {
			this.val = val;
			this.sum = sum;
		}
	}
	
	 private static int read() throws Exception {
	        int d, o;
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
