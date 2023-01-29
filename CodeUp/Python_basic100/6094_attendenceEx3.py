# 출석 번호를 n번 무작위로 불렀을 때, 가장 빠른 번호를 출력해 보자.

# 단, 첫 번째 번호와 마지막 번호가 몇 번인지는 아무도 모른다.
# 음수(-) 번호, 0번 번호도 있을 수 있다.
n = int(input())
a = list(map(int, input().split()))
b = 0
c = 1

while c < n :
    if a[0] <= a[c] :
        c += 1
        continue
    elif a[0] >= a[c] :
        b = a[0]
        a[0] = a[c]
        a[c] = b
        c += 1
        
print(a[0])