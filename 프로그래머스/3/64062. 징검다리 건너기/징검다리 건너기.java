class Solution {
    
    int segments[];
    int size;
    int n;
    public int solution(int[] stones, int k) {
        n = stones.length;
        size = 1;
        while(size < n) {
            size <<= 1;
        }
        
        segments = new int[size * 2 + 1];
        
        for(int i = size + 1; i < size + n + 1; i++) {
            segments[i] = stones[i - size - 1];
        }
         int segmentSize = segments.length - 1;
        while(segmentSize > 1) {
            segments[(segmentSize + 1) >> 1] = Math.max(segments[segmentSize], segments[segmentSize - 1]);
            segmentSize -= 2;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n - k + 1; i++) {
            min = Math.min(min, query(i, i + k - 1, 2, 1, size));
        }
        
        return min;

    }
    
    public int query(int left, int right, int node, int start, int end) {
        if(left > end || right < start) return 0;
        
        if(left <= start && end <= right) return segments[node];
        
        int mid = (start + end) >> 1;
        return Math.max(query(left, right, (node << 1) - 1, start, mid),
                       query(left, right, node << 1, mid + 1, end));
    }
}