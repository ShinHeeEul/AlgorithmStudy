import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);


        long N = Long.parseLong(br.readLine());

        int tmp = 1500000;
        long[] memory = new long[tmp];
        memory[0] = 0;
        memory[1] = 1;
         for(int i = 2; i < tmp; i++)
             memory[i] = (memory[i-1] + memory[i-2]) % 1000000;

         if(N >= tmp) {
             N %= tmp;
         }


        System.out.println(memory[(int)N]);

        bw.flush();
        br.close();
        bw.close();
    }
}