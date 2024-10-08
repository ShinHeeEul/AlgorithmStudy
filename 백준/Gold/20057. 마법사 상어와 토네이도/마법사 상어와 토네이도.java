import java.util.Arrays;

class Main {

    static int[][] map;
    // 0: 좌측, 1: 밑으로, 2: 우측, 3: 위로
    static int direction = 0;
    static int n;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {-1, 0, 1, 0};

    static int[][] teni = {{-1, 1},{1, 1}, {1, -1}, {-1, -1}};
    static int[][] tenj = {{-1, -1},{-1, 1},{1, 1}, {-1, 1}};
    static int[][] seveni = {{-1, 1}, {0, 0}};
    static int[][] sevenj = {{0,0},{-1, 1}};

    public static void main(String[] args) throws Exception {
        n = read();
        map = new int[n + 4][n + 4];

        for(int i = 2; i < map.length - 2; i++) {
            for(int j = 2; j < map[i].length - 2; j++) {
                map[i][j] = read();
            }
        }

        Tornado();

        int ans = 0;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                if(((i >= 2) && (i <= n + 1)) && ((j >= 2) && (j <= n + 1))) continue;
                ans += map[i][j];
            }
        }

        System.out.println(ans);
    }

    public static void Tornado() {
        int ii = n/2 + 2;
        int jj = n/2 + 2;

        for(int i = 1; i <= n - 1; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < i; k++) {
                    ii += di[direction];
                    jj += dj[direction];

                    wind(ii, jj);
                }
                direction = (direction + 1) % 4;
            }
        }
        for(int i = 0; i < n-1; i++) {
            wind(ii, --jj);
        }
    }

    public static void wind(int i, int j) {
        double remind = map[i][j];
        int a = 0;
        //7%
        int seven = (int) (remind * 0.07);
        a += (seven * 2);
        map[i + seveni[direction % 2][0]][j + sevenj[direction % 2][0]] += seven;
        map[i + seveni[direction % 2][1]][j + sevenj[direction % 2][1]] += seven;
        //10%
        int ten = (int) (remind * 0.1);
        a += (ten * 2);
        map[i + teni[direction][0]][j + tenj[direction][0]] += ten;
        map[i + teni[direction][1]][j + tenj[direction][1]] += ten;
        //1%
        int one = (int) (remind * 0.01);
        a += (one * 2);
        int oneDir = (direction + 2) % 4;
        map[i + teni[oneDir][0]][j + tenj[oneDir][0]] += one;
        map[i + teni[oneDir][1]][j + tenj[oneDir][1]] += one;
        //2%
        int two = (int) (remind * 0.02);
        a += (two * 2);
        map[i + seveni[direction % 2][0] * 2][j + sevenj[direction % 2][0] * 2] += two;
        map[i + seveni[direction % 2][1] * 2][j + sevenj[direction % 2][1] * 2] += two;

        //5%
        int five = (int) (remind * 0.05);
        map[i + di[direction] * 2][j + dj[direction] * 2] += five;
        a += five;

        map[i][j] = 0;
        map[i + di[direction]][j + dj[direction]] += (remind - a);
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