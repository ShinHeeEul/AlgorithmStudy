    import org.w3c.dom.Node;

    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Queue;

    class Main {


        static int[][] map;
        // 0 : 위쪽, 1 : 오른쪽, 2 : 왼쪽, 3 : 아래
        static boolean[][][] walls;
        static int[] di = {-1, 0, 0, 1};
        static int[] dj = {0, 1, -1, 0};
        static int[] spreadI = {0, 1, 1, 0 };
        static int[] spreadJ = {1, 0, 0, 1 };
        static int chocolate = 0;
        static int R;
        static int C;
        static int K;
        static ArrayList<Integer[]> researches = new ArrayList<>();
        static ArrayList<Heater> heaters = new ArrayList<>();
        static boolean[][] visited;

        public static void main(String[] args) throws Exception {

            R = read();
            C = read();
            K = read();

            map = new int[R + 8][C + 8];
            walls = new boolean[R + 8][C + 8][4];

            for(int i = 4; i < R + 4; i++) {
                for(int j = 4; j < C + 4; j++) {
                    int a = read();
                    if(a == 1) heaters.add(new Heater(i,j,1));
                    else if(a == 2) heaters.add(new Heater(i,j,2));
                    else if(a == 3) heaters.add(new Heater(i,j,0));
                    else if(a == 4) heaters.add(new Heater(i, j, 3));
                    else if(a == 5) researches.add(new Integer[]{i, j});
                }
            }

            int W = read();

            for(int i = 0; i < W; i++) {
                    int x = read() + 3;
                    int y = read() + 3;
                    int t = read();
                    if(t == 0) {
                        walls[x][y][0] = true;
                        walls[x-1][y][3] = true;
                    } else if(t == 1) {
                        walls[x][y][1] = true;
                        walls[x][y+1][2] = true;
                    }
            }

            while(chocolate <= 100) {
                // 1. 집에 있는 모든 온풍기에서 바람이 한 번 나옴
                for(Heater heater : heaters) {
                    fire(heater);
                }

                // 2. 온도가 조절됨
                changeDegree();
                // 3. 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
                coolDown();
                // 4. 초콜릿을 하나 먹는다.
                chocolate++;
                // 5. 조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.
                boolean b = true;
                for(Integer[] research : researches) {
                    if(map[research[0]][research[1]] < K) {
                        b = false;
                        break;
                    }
                }
                if(b) {
                    System.out.print(chocolate);
                    return;
                }
            }
            System.out.print(101);


        }

        public static void fire(Heater heater) {
            int i = heater.i;
            int j = heater.j;
            int dir = heater.dir;
            bfs(i + di[dir],j + dj[dir],dir);
        }

        public static void bfs(int i, int j, int dir) {
            Queue<Node> queue = new LinkedList<>();
            visited = new boolean[R + 8][C + 8];
            int[] spreads = spreadSwitcher(dir);

            queue.add(new Node(i, j, 5));
            visited[i][j] = true;
            while(!queue.isEmpty()) {
                Node node = queue.poll();

                map[node.i][node.j] += node.val;
                if(node.val == 1) continue;
                 // +
                int maxI = node.i + di[dir] + spreadI[dir];
                int maxJ = node.j + dj[dir] + spreadJ[dir];
                if(!walls[node.i][node.j][spreads[1]] && !walls[maxI][maxJ][switcher(dir)] && !visited[maxI][maxJ] && check(maxI, maxJ)) {
                    visited[maxI][maxJ] = true;
                    queue.add(new Node(maxI, maxJ, node.val - 1));
                }

                // 중앙
                int middleI = node.i + di[dir];
                int middleJ = node.j + dj[dir];
                if(!walls[middleI][middleJ][switcher(dir)] && !visited[middleI][middleJ] && check(middleI, middleJ)) {
                    visited[middleI][middleJ] = true;
                    queue.add(new Node(middleI, middleJ, node.val - 1));
                }

                // -
                int minI = node.i + di[dir] - spreadI[dir];
                int minJ = node.j + dj[dir] - spreadJ[dir];
                if(!walls[node.i][node.j][spreads[0]] && !walls[minI][minJ][switcher(dir)] && !visited[minI][minJ] && check(minI, minJ)) {
                    visited[minI][minJ] = true;
                    queue.add(new Node(minI, minJ, node.val - 1));
                }
            }
        }

        public static boolean check(int i, int j) {
            return i >= 4 && j >= 4 && i <= R + 3 && j <= C + 3;
        }

        public static int[] spreadSwitcher(int dir) {
            if(dir == 0 || dir == 3) return new int[] {2, 1};
            return new int[] {0,3};
        }

        public static void changeDegree() {
            int[][] tmp = new int[R + 8][C + 8];
            for(int i = 4; i < R + 4; i++) {
                for(int j = 4; j < C + 4; j++) {
                    tmp[i][j] = map[i][j];
                    for(int k = 0; k < 4; k++) {
                        int ii = i + di[k];
                        int jj = j + dj[k];
                        tmp[i][j] += calculate(i,j,ii,jj,k);
                    }
                }
            }

            for(int i = 4; i < R + 4; i++) {
                map[i] = tmp[i].clone();
            }
        }

        public static int calculate(int beforeI, int beforeJ, int afterI, int afterJ, int dir) {
            if(walls[beforeI][beforeJ][dir] || afterI < 4 || afterJ < 4 || afterI > R + 3 || afterJ > C + 3) return 0;
            return (map[afterI][afterJ] - map[beforeI][beforeJ]) / 4;
        }

        public static void coolDown() {
//            for(int a = 4; a < R + 4; a++) {
//                for(int b = 4; b < C + 4; b++) {
//                    if(a >= 5 && b >= 5 && a <= R + 2 && b <= C + 2) continue;
//                    if(a == 4 || b == 4 || a == R + 3 || b == C + 2) map[a][b] = Math.max(0, map[a][b] - 1);
//                    else map[a][b] = 0;
//                }
//            }
            for(int a = 4; a < R + 4; a++) {
                map[a][4] = Math.max(0, map[a][4] - 1);
                map[a][C+3] = Math.max(0, map[a][C+3] - 1);
            }
            for(int b = 5; b < C + 3; b++) {
                map[4][b] = Math.max(0, map[4][b]-1);
                map[R+3][b] = Math.max(0,map[R+3][b]-1);
            }
        }

        public static int switcher(int dir) {
            if(dir == 0) return 3;
            if(dir == 1) return 2;
            if(dir == 2) return 1;
            else return 0;
        }


        public static class Node {
            int i;
            int j;
            int val;

            public Node(int i, int j, int val) {
                this.i = i;
                this.j = j;
                this.val = val;
            }
        }

        public static class Heater {
            int i;
            int j;
            int dir;

            public Heater(int i, int j, int dir) {
                this.i = i;
                this.j = j;
                this.dir = dir;
            }
        }

        private static int read() throws Exception {
            int d, o;
            boolean negative = false;
            d = System.in.read();
            if (d == 45) {
                negative = true;
                d = System.in.read();
            }

            o = d & 15;
            while ((d = System.in.read()) > 32)
                o = (o << 3) + (o << 1) + (d & 15);

            return negative ? -o : o;
        }
    }