import java.util.*;
import java.io.*;

class Solution
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] list = new ArrayList[N + 1];
			boolean[] visited = new boolean[N + 1];
			
			for(int i = 1 ; i <= N; i++) list[i] = new ArrayList<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			int count = 0;
			visited[1] = true;
			for(int friend : list[1]) {
				if(!visited[friend]) {
					count++;
					visited[friend] = true;
				}
				for(int friendFriend : list[friend]) {
					if(!visited[friendFriend]) {
						count++;
						visited[friendFriend] = true;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}