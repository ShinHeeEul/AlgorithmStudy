import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] list;
    static int[] score;
    static int min = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        score = new int[N+1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B));
        }

        for(int i = 1; i <= N; i++) {
            Topol(i);
        }

        for(int i = 1; i <= N; i++) System.out.print(score[i] + 1 + " ");

    }

    public static void Topol(int i) {
        for(Node n : list[i]) {
            score[n.before] = Math.max(score[n.before], score[i] + 1);
        }
        min = Math.min(min, score[i]);
    }

    static class Node {
        int before;

        public Node(int before) {
            this.before = before;
        }
    }

}