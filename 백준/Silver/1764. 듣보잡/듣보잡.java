import java.io.*;
import java.util.*;

class Main {

    static String s = "";
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) map.put(br.readLine(), 1);
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < M;i++) {
            String s = br.readLine();
            if(map.containsKey(s)) answer.add(s);
        }
        Collections.sort(answer);

        System.out.println(answer.size());
        answer.stream().forEach(System.out::println);

    }
}