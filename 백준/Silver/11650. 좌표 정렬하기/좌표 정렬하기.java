import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        //Comparator 요약한 것
        /*Arrays.sort(arr, new Comparator<int[]>() {
	    @Override
	    public int compare(int[] e1, int[] e2) {
	    	if(e1[0] == e2[0]) {		// 첫번째 원소가 같다면 두 번째 원소끼리 비교
	    		return e1[1] - e2[1];
	    	}
	    	else {
	    		return e1[0] - e2[0];
	    	}
	    }
       });*/
        
        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]) return e1[1] - e2[1];
            else
                return e1[0] - e2[0];
        });

        for(int[] i : arr)
            bw.write(i[0] + " "+  i[1] + "\n");


        bw.flush();
    }

}