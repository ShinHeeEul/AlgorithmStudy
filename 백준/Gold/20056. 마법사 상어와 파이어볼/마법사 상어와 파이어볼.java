import java.io.*;
import java.util.*;

class Main {


    static ArrayList<fireBall>[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+2][N+2];

        for(int a =0 ; a < N+2; a++) {
            for(int b = 0; b < N+2; b++) {
                map[a][b] = new ArrayList();
            }
        }
        //맵 생성 후 fireball 배치
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new fireBall(d,s,m));
        }


        for(int i = 0; i < K; i++) {
            //맵 새로 생성해주고
            ArrayList<fireBall>[][] tmp = new ArrayList[N+2][N+2];
            for(int a =0 ; a < N+2; a++) {
                for(int b = 0; b < N+2; b++) {
                    tmp[a][b] = new ArrayList();
                }
            }
            // 맵 전체를 돌면서 파이어 볼을 그다음 위치로 옮기고
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    for(int m = 0; m < map[j][k].size(); m++) {
                        fireBall b = map[j][k].get(m);

                        //이동 위치 계산
                        int[] ii = GoTo(b, j, k);
                        if(tmp[ii[0]][ii[1]].isEmpty()) tmp[ii[0]][ii[1]].add(b);
                        //비어 있다면 그냥 옮기기
                        else {
                            fireBall arrive = tmp[ii[0]][ii[1]].get(0);
                            //만약 이동 위치가 비어있지 않다면
                            // m,s 계산해주고
                            arrive.m += b.m;
                            arrive.s += b.s;
                            arrive.count += 1;
                            // d 같은 방향인지 확인 후
                            if (arrive.direct) {
                                //짝수면 같은거 홀수면 다른 거
                                if ((arrive.d + b.d) % 2 != 0) {
                                    arrive.direct = false;
                                }
                            }
                        }
                    }
                }
            }

            // 맵 다시 한번 돌면서 파이어 볼 폭파
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if(tmp[j][k].isEmpty()) continue;
                    fireBall b = tmp[j][k].get(0);
                    if(b.count == 1) continue;
                    tmp[j][k].remove(0);
                    if((b.m/5) == 0) continue;
                    //이동 위치 계산
                    if(b.direct) {
                        tmp[j][k].add(new fireBall(0,b.s/b.count,b.m/5));
                        tmp[j][k].add(new fireBall(2,b.s/b.count,b.m/5));
                        tmp[j][k].add(new fireBall(4,b.s/b.count,b.m/5));
                        tmp[j][k].add(new fireBall(6,b.s/b.count,b.m/5));
                    }
                    else {
                        tmp[j][k].add(new fireBall(1,b.s/b.count,b.m/5));
                        tmp[j][k].add(new fireBall(3,b.s/b.count,b.m/5));
                        tmp[j][k].add(new fireBall(5,b.s/b.count,b.m/5));
                        tmp[j][k].add(new fireBall(7,b.s/b.count,b.m/5));
                    }
                }
            }

            //맵 복구
            for(int j = 1; j <= N; j++)
                map[j] = tmp[j].clone();
        }

        int weight = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 0; k < map[i][j].size(); k++) {
                    weight += map[i][j].get(k).m;
                }
            }
        }

        System.out.println(weight);
    }

    private static int[] GoTo(fireBall b,int r, int c) {
        int s = b.s;
        switch (b.d) {
            case 0:
                r -= s;
                break;
            case 1:
                r -= s;
                c += s;
                break;
            case 2:
                c += s;
                break;
            case 3:
                c += s;
                r += s;
                break;
            case 4:
                r += s;
                break;
            case 5:
                r += s;
                c -= s;
                break;
            case 6:
                c -= s;
                break;
            case 7:
                r -= s;
                c -= s;
                break;
        }

        //초과된거 되돌리기
        //나머지로

        r %= N;
        c %= N;
        if(r <= 0) r += N;
        if(c <= 0) c += N;

        int[] ii = {r,c};
        return ii;
    }

    public static class fireBall{
        int d;
        int s;
        int m;
        boolean direct;
        int count;

        public fireBall(int d, int s, int m) {
            this.d = d;
            this.s = s;
            this.m = m;
            this.direct = true;
            this.count= 1;
        }

        public fireBall(int s, int m) {
            this.s = s;
            this.m = m;
            this.direct = true;
            this.count = 0;
        }
    }
}