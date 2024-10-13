class Main {

        public static void main(String[] args) throws Exception {

            int[][] node = new int[3][2];

            for(int i = 0; i < 3; i++) {
                node[i][0] = read();
                node[i][1] = read();
            }

            int a = ccw(node);
            if(a < 0) System.out.println(-1);
            else if(a > 0) System.out.println(1);
            else System.out.println(0);


        }

        public static int ccw(int[][] node) {

            int a = (node[0][0] * node[1][1]) + (node[1][0] * node[2][1]) + (node[2][0] * node[0][1]);
            int b = (node[0][1] * node[1][0]) + (node[1][1] * node[2][0]) + (node[2][1] * node[0][0]);
            return a - b;
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