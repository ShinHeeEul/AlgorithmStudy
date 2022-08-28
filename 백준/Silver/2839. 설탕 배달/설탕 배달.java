import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        int sum = N/5;
        int tmp = N;
            tmp %= 5;
            if ((tmp % 3) == 0){
                sum += tmp / 3;
                System.out.println(sum);
            }
            else {
                for(int i = 0; i < N/5; i++) {
                    sum--;
                    tmp += 5;
                    if((tmp % 3) == 0) {
                        sum += tmp / 3;
                        System.out.println(sum);
                        return;
                    }
                }
                System.out.println(-1);
            }
        bw.flush();
        br.close();
        bw.close();
    }
}