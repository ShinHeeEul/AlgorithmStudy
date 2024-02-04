from itertools import permutations

N,M = map(int,input().split())
a = []
for i in range(1,N+1):
    a.append(i)
    
l = list(permutations(a, M))

for i in l:
    print(' '.join(map(str,i)))

