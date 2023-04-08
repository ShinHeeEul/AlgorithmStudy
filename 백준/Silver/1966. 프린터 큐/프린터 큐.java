import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Node> queue = new LinkedList<>();

            int[] map = new int[10];
            //nlogn
            for(int j = 0; j < N; j++) {
                Node n = new Node(j, Integer.parseInt(st.nextToken()));
                queue.add(n);
                map[n.important]++;
            }

            //중요도가 최고가 아닌 경우
            //다시 queue에 넣으면 됨.
            //중요도가 최고인 경우
            //count 1 증가
            //중요도가 최고인지는 어떻게 판단?
            int count = 0;
            //map의 최댓값부터 하나씩 출력하면서 체크
            //map[k]가 0이 아닐 경우
            //돌면서 0까지 만들어주기 -> k를 만나면 poll하고 map[k] -1;
            //k가 0이 될때까지

            for(int k = 9; k > 0; ) {
                if(map[k] == 0) {
                    k--;
                    continue;
                }
                Node n = queue.poll();
                if(n.important != k) queue.add(n);
                else {
                    count++;
                    map[k]--;
                    if(n.index == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }




        }
        bw.flush();
        bw.close();
    }

    private static class Node {

        int index;
        int important;

        Node(int i, int j) {
            index = i;
            important = j;
        }
    }
}