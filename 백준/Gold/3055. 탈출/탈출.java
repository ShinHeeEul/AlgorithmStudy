import java.util.*;
import java.io.*;


public class Main
{
    static String[][] map;
    static String[][] mapTmp;
    static int count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        mapTmp = new String[R][C];
        count = 0;

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = s.charAt(j) + "";
        }

        while(next());

        System.out.println(count==-1?"KAKTUS":count);
    }

    public static boolean next() {
        for(int i = 0; i < map.length; i++) {
            mapTmp[i] = map[i].clone();
        }
        boolean b= true;
        count++;
        boolean bb = true;
        for(int i =0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                String current = map[i][j];

                int check = 0;
                switch(current) {
                    case "S":
                        bb = false;
                        if(j != map[0].length-1)
                            check += fillD(i, j+1);
                        if(j != 0)
                            check += fillD(i, j-1);
                        if(i != map.length-1)
                            check += fillD(i+1, j);
                        if(i != 0)
                            check += fillD(i-1, j);
                        if(check >= 100) b = false;
                        break;

                    case "*":
                        if(j != mapTmp[0].length-1)
                            fillstar(i, j+1);
                        if(j != 0)
                            fillstar(i, j-1);
                        if(i != map.length-1)
                            fillstar(i+1, j);
                        if(i != 0)
                            fillstar(i-1, j);
                        break;
                }

            }
        }
        if(bb) {
            count = -1;
            b = false;
        }
        for(int i = 0; i < map.length; i++) {
            map[i] = mapTmp[i].clone();
        }
        return b;
    }

    public static int fillD(int i , int j) {
        String tmp = mapTmp[i][j];
        switch(tmp) {
            case ".":
                mapTmp[i][j] = "S";
                return 2;
            case "D":
                mapTmp[i][j] = "S";
                return 100;
            default:
                return 0;
        }
    }

    public static void fillstar(int i , int j) {
        String tmp = mapTmp[i][j];
        switch(tmp) {
            case ".":
                mapTmp[i][j] = "*";
                break;
            case "S":
                mapTmp[i][j] = "*";
                break;
        }
    }
}