import java.io.*;
import java.util.Arrays;


public class Main {


    static class obj implements Comparable<obj>  {
        String S;

        public obj(String s) {
            S = s;
        }

        @Override
        public String toString() {
            return S;
        }

        @Override
        public boolean equals(Object o) {
            obj O = null;
            if(o instanceof obj) {

                O = (obj) o;
                if(O.S.equals(this.S)) return true;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return S.hashCode();
        }

        @Override
        public int compareTo(obj o) {
            if(this.S.length() > o.S.length()) return 1;
            else if(this.S.length() < o.S.length()) return -1;
            else if(this.S.length() == o.S.length()){
                for(int i = 0; i < this.S.length(); i++){
                    if(this.S.charAt(i) > o.S.charAt(i)) return 1;
                    else if(this.S.charAt(i) < o.S.charAt(i)) return -1;
                }
                    return -1;
            }
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        obj[] arr = new obj[N];
        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            arr[i] = new obj(S);
        }

        Arrays.stream(arr).sorted().distinct()
                .forEach(System.out::println);



        bw.flush();
        br.close();
        bw.close();
    }
}