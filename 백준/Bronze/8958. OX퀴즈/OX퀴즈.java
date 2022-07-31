import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N;i++) {
            char[] ch = br.readLine().toCharArray();
            int sum = 0;
            int cont = 1;
            for(int j = 0; j < ch.length; j++) {
                if(ch[j] == 'O')  {
                    sum += cont;
                    cont ++;
                }
                else cont = 1;
            }
            bw.write(sum + "\n");
        }


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}