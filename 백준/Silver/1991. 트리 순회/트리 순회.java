import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Integer[][] list;
    static StringBuilder ans;
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception {
        int N = read();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new Integer[26][2];

        for(int i = 0; i < 26; i++)
            Arrays.fill(list[i], -1);

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';
            int c = st.nextToken().charAt(0) - 'A';

            if(b > 0) {
                list[a][0] = b;
            }
            if(c > 0) {
                list[a][1] = c;
            }
        }

        ans = new StringBuilder();
        front(0);
        System.out.println(ans);
        ans = new StringBuilder();
        mid(0);
        System.out.println(ans);
        ans = new StringBuilder();
        back(0);
        System.out.println(ans);


    }

    private static void front(int root) {
            int left = list[root][0];
            int right = list[root][1];

            ans.append((char) ('A' + root));
            if(left > 0) front(left);
            if(right > 0) front(right);
    }

    private static void mid(int root) {
        int left = list[root][0];
        int right = list[root][1];

        if(left > 0) mid(left);
        ans.append((char) ('A' + root));
        if(right > 0) mid(right);
    }


    private static void back(int root) {
        int left = list[root][0];
        int right = list[root][1];

        if(left > 0) back(left);
        if(right > 0) back(right);
        ans.append((char) ('A' + root));

        //양쪽 다 없으면 root
        // 왼쪽이 있으면 왼쪽 가고, 오른쪽 있으면 오른쪽 가고?
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
