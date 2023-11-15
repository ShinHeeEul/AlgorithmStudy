import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] people = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        HashSet<Integer>[] list = new HashSet[N+1];

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < list.length; i++) {
            list[i] = new HashSet<>();
        }

        int know = Integer.parseInt(st.nextToken());
        for(int i = 0; i < know; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            people[tmp] = true;
            queue.add(tmp);
        }

        int count = 0;

        ArrayList<Integer>[] party = new ArrayList[M];


        for(int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int hell = Integer.parseInt(st.nextToken());
            int[] t = new int[hell];
            for(int j = 0; j < hell; j++) {
                t[j] = Integer.parseInt(st.nextToken());
                party[i].add(t[j]);
            }
            for(int j = 0; j < hell; j++) {
                int a = t[j];
                for(int k = j+1; k < hell; k++) {
                    int b = t[k];
                    list[a].add(b);
                    list[b].add(a);
                }
            }
        }

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int i : list[n]) {
                if(people[i]) continue;
                people[i] = true;
                queue.add(i);
            }
        }

        for(ArrayList<Integer> arr : party) {
            for(int i : arr) {
                if(people[i]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(M - count);
    }
}
