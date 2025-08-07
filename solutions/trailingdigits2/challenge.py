
n = int(input())
mod = 10000000000
res= 0
for i in range(1, n+1):
    res += pow(i,i,mod)
    res %= mod

print(res)