# [Platinum V] 최솟값 찾기 - 11003 

[문제 링크](https://www.acmicpc.net/problem/11003) 

### 성능 요약

메모리: 615552 KB, 시간: 2452 ms

### 분류

자료 구조, 우선순위 큐, 덱

### 문제 설명

<p>N개의 수 A<sub>1</sub>, A<sub>2</sub>, ..., A<sub>N</sub>과 L이 주어진다.</p>

<p>D<sub>i</sub> = A<sub>i-L+1</sub> ~ A<sub>i</sub> 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 A<sub>i</sub>는 무시하고 D를 구해야 한다.</p>

### 입력 

 <p>첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)</p>

<p>둘째 줄에는 N개의 수 A<sub>i</sub>가 주어진다. (-10<sup>9</sup> ≤ A<sub>i</sub> ≤ 10<sup>9</sup>)</p>

### 출력 

 <p>첫째 줄에 D<sub>i</sub>를 공백으로 구분하여 순서대로 출력한다.</p>


## Priority Queue를 이용한 오답
Priority Queue를 사용하여 계산하였지만 Priority Queue 내부의 poll()과 peek()의 연산 과정이 오래 걸려 fail.

```java
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        //우선순위 큐는 낮은 것부터 나감
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            int index1 = i;
            if(!priorityQueue.isEmpty()) priorityQueue.removeIf(a -> a > A[index1]);

            if(i >= L)
                priorityQueue.remove(A[i - L]);
            priorityQueue.add(A[i]);

            bw.write(priorityQueue.peek() + " ");
        }

        bw.flush();
    }
}
```
