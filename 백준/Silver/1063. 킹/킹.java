    import java.io.*;
    import java.util.*;


    //백준 문제 풀이
    class Main {
        static int[][] chess;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            chess = new int[10][10];

            StringTokenizer st = new StringTokenizer(br.readLine());

            char[] tmp = st.nextToken().toCharArray();
            int[] king = new int[]{9 - Integer.parseInt(tmp[1] + ""), tmp[0] - 'A' + 1};
            tmp = st.nextToken().toCharArray();
            int[] stone = new int[]{9 - Integer.parseInt(tmp[1] + ""), tmp[0] - 'A' + 1};
            int N = Integer.parseInt(st.nextToken());

            chess[king[0]][king[1]] = 1;
            chess[stone[0]][stone[1]] = -1;

            HashMap<String, int[]> map = new HashMap<>();

            map.put("R", new int[]{0,1});
            map.put("L", new int[]{0,-1});
            map.put("B", new int[]{1,0});
            map.put("T", new int[]{-1,0});
            map.put("RT", new int[]{-1,1});
            map.put("LT", new int[]{-1,-1});
            map.put("RB", new int[]{1,1});
            map.put("LB", new int[]{1,-1});

            for(int i = 0; i < N; i++) {

                int[] goTo = map.get(br.readLine());
                int kCol = king[0];
                int kRow = king[1];
                int sCol = stone[0];
                int sRow = stone[1];

                boolean b = ValidChess(goTo, kCol, kRow);

                if(!b) continue;

                kCol += goTo[0];
                kRow += goTo[1];


                if((kRow == sRow) && (kCol == sCol)) {
                    if(!ValidChess(goTo, sCol, sRow)) continue;
                    sCol += goTo[0];
                    sRow += goTo[1];
                }
                //king 위치 변화
                king[0] = kCol;
                king[1] = kRow;
                //stone 위치 변화
                stone[0] = sCol;
                stone[1] = sRow;
            }
            String KS = "";
            String SS = "";
            KS += (char) ('A' + king[1] -1);
            KS += 9 - king[0];

            SS += (char) ('A' + stone[1] -1);
            SS += 9 - stone[0];
            System.out.println(KS);
            System.out.println(SS);
        }

        private static boolean ValidChess(int[] goTo, int kCol, int kRow) {
            if((kCol + goTo[0] == 0) || (kCol + goTo[0] == 9)) {
                return false;
            }
            if((kRow + goTo[1] == 0) || (kRow + goTo[1] == 9)) {
                return false;
            }
            return true;
        }

    }