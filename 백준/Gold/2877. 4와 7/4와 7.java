import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws Exception {
		
		int N = read();
		
		int size = 0;
		
		int sum = 0;
		int nxt = 2;
		int before = 0;
		while(sum < N) {
			before = sum;
			sum += nxt;
			nxt <<= 1;
		}
		
		
		nxt >>= 1;
		StringBuilder sb = new StringBuilder();
		while(nxt > 1) {
			nxt >>= 1;
			if(before + nxt < N) {
				sb.append('7');
				N -= nxt;
			} else {
				sb.append('4');
			}
		}
		
		System.out.println(sb);
	}


	
	
    private static int read() throws IOException {
        int d, o = 0;
        boolean negative = false;

        while ((d = System.in.read()) <= 32); 

        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        do {
            o = (o << 3) + (o << 1) + (d & 15); // o = o * 10 + (d - '0')
        } while ((d = System.in.read()) >= '0' && d <= '9');

        return negative ? -o : o;
    }
}
