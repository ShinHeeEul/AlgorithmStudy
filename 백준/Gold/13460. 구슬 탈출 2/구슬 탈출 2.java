import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static final char BLUE = 'B';
    static final char HOLE = 'O';
    static final char RED = 'R';
    static final char DOT = '.';
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(map, 0));
        boolean b = true;
        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(n.count == 10) {
                b = false;
                continue;
            }
            char[][] downTmp = new char[N][M];
            for(int i = 0; i < map.length; i++) {
                downTmp[i] = n.map[i].clone();
            }
            int k = down(downTmp);
            if(k == 1) {
                System.out.println(n.count+1);
                return;
            }else if(k == 0) {
                queue.add(new Node(downTmp, n.count+1));
            }

            char[][] upTmp = new char[N][M];
            for(int i = 0; i < map.length; i++) {
                upTmp[i] = n.map[i].clone();
            }
            k = up(upTmp);
            if(k == 1) {
                System.out.println(n.count+1);
                return;
            }else if(k == 0) {
                queue.add(new Node(upTmp, n.count+1));
            }
            char[][] leftTmp = new char[N][M];
            for(int i = 0; i < map.length; i++) {
                leftTmp[i] = n.map[i].clone();
            }
            k = left(leftTmp);
            if(k == 1) {
                System.out.println(n.count+1);
                return;
            }else if(k == 0) {
                queue.add(new Node(leftTmp, n.count+1));
            }

            char[][] rightTmp = new char[N][M];
            for(int i = 0; i < map.length; i++) {
                rightTmp[i] = n.map[i].clone();
            }
            k = right(rightTmp);
            if(k == 1) {
                System.out.println(n.count+1);
                return;
            }else if(k == 0) {
                queue.add(new Node(rightTmp, n.count+1));
            }
        }

        if(!b) {
            System.out.println(-1);
        }

    }

    static public int down(char[][] map) {
        boolean b = false;
        for(int i = map.length-1; i > 0; i--) {
            for(int j = 1; j < map[i].length; j++) {
                int x = i+1;
                int y = j;
                switch(map[i][j]) {
                    case BLUE :

                        while(map[x][y] == DOT) {
                            x++;
                        }
                        if(map[x][y] == HOLE) {
                            return -1;
                        }
                        if(x != i+1) {
                            map[i][j] = DOT;
                        }
                        map[x-1][y] = BLUE;
                        break;
                    case RED:

                        while(map[x][y] == DOT) {
                            x++;
                        }
                        if(map[x][y] == HOLE) {
                            b = true;
                            map[i][j] = DOT;
                            continue;
                        }
                        if(x != i+1) {
                            map[i][j] = DOT;
                        }
                        map[x-1][y] = RED;
                        break;
                }
            }
        }
        if(b) {
            return 1;
        }
        return 0;
    }

    static public int up(char[][] map) {
        boolean b = false;
        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                int x = i-1;
                int y = j;
                switch(map[i][j]) {
                    case BLUE:

                        while(map[x][y] == DOT) {
                            x--;
                        }
                        if(map[x][y] == HOLE) {
                            return -1;
                        }
                        if(x != i-1) {
                            map[i][j] = DOT;
                        }
                        map[x+1][y] = BLUE;
                        break;
                    case RED:

                        while(map[x][y] == DOT) {
                            x--;
                        }
                        if(map[x][y] == HOLE) {
                            b = true;
                            map[i][j] = DOT;
                            continue;
                        }
                        if(x != i-1) {
                            map[i][j] = DOT;
                        }
                        map[x+1][y] = RED;
                        break;
                }
            }
        }
        if(b) {
            return 1;
        }
        return 0;
    }

    static public int left(char[][] map) {
        boolean b = false;
        for(int i = 1; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                int x = i;
                int y = j-1;
                switch(map[i][j]) {
                    case BLUE:

                        while(map[x][y] == DOT) {
                            y--;
                        }
                        if(map[x][y] == HOLE) {
                            return -1;
                        }
                        if(y != j-1) {
                            map[i][j] = DOT;
                        }
                        map[x][y+1] = BLUE;
                        break;
                    case RED:
                        while(map[x][y] == DOT) {
                            y--;
                        }
                        if(map[x][y] == HOLE) {
                            b = true;
                            map[i][j] = DOT;
                            continue;
                        }
                        if(y != j-1) {
                            map[i][j] = DOT;
                        }
                        map[x][y+1] = RED;
                        break;
                }
            }
        }
        if(b) {
            return 1;
        }
        return 0;
    }

    static public int right(char[][] map) {
        boolean b = false;
        for(int i = 1; i < map.length; i++) {
            for(int j = map[i].length-1; j > 0; j--) {
                int x = i;
                int y = j+1;
                switch(map[i][j]) {
                    case BLUE:

                        while(map[x][y] == DOT) {
                            y++;
                        }
                        if(map[x][y] == HOLE) {
                            return -1;
                        }
                        if(y != j+1) {
                            map[i][j] = DOT;
                        }
                        map[x][y-1] = BLUE;
                        break;
                    case RED:

                        while(map[x][y] == DOT) {
                            y++;
                        }
                        if(map[x][y] == HOLE) {
                            b = true;
                            map[i][j] = DOT;
                            continue;
                        }
                        if(y != j+1) {
                            map[i][j] = DOT;
                        }
                        map[x][y-1] = RED;
                        break;
                }
            }
        }
        if(b) {
            return 1;
        }
        return 0;
    }

    static class Node {
        char[][] map;
        int count;

        public Node(char[][] map, int count) {
            this.map = new char[N][M];
            for(int i = 0; i < map.length; i++) {
                this.map[i] = map[i].clone();
            }
            this.count = count;
        }


    }
}
