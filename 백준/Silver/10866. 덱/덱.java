import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());


        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {

                case("push_front"):
                    queue.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case("push_back") :
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case("pop_front") :
                    if(!queue.isEmpty()) System.out.println(queue.removeFirst());
                    else System.out.println(-1);
                    break;
                case("pop_back") :
                    if(!queue.isEmpty()) System.out.println(queue.removeLast());
                    else System.out.println(-1);
                    break;
                case("size") :
                    System.out.println(queue.size());
                    break;
                case("empty") :
                    if(!queue.isEmpty()) System.out.println(0);
                    else System.out.println(1);
                    break;
                case("front") :
                    if(!queue.isEmpty()) System.out.println(queue.getFirst());
                    else System.out.println(-1);
                    break;
                case("back") :
                    if(!queue.isEmpty()) System.out.println(queue.getLast());
                    else System.out.println(-1);
                    break;
                default:
            }
        }


    }
}