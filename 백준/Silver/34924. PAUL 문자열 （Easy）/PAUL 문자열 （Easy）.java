import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ca = br.readLine().toCharArray();
        // PAUL -> P 다음 A까지 거리
        ArrayList<Integer> P = new ArrayList<>();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> U = new ArrayList<>();
        ArrayList<Integer> L = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            if(ca[i] == 'P') P.add(i);
            else if(ca[i] == 'A') A.add(i);
            else if(ca[i] == 'U') U.add(i);
            else if(ca[i] == 'L') L.add(i);
        }

        if((N - 4) % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int bp = 0;
        int bu = 0;
        int bl = 0;
        for(int p : P) {
            if(p % 2 != 0) continue;
            for(int ia = bp; ia < A.size(); ia++) {
                int a = A.get(ia);
                if(p > a) {
                    bp = ia;
                    continue;
                }
                if((a - p) % 2 == 0) continue;
                for(int iu = bu; iu < U.size(); iu++) {
                    int u = U.get(iu);
                    if(a > u) {
                        bu = iu;
                        continue;
                    }
                    if((u - a) % 2 == 0) continue;
                    for(int il = bl; il < L.size(); il++) {
                        int l = L.get(il);
                        if(u > l) {
                            bl = il;
                            continue;
                        }
                        if((l - u) % 2 == 0 || (N - l) % 2 == 0) continue;
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
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