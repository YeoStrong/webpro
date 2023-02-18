n = int(input())

for _ in range(n):
    m, s = input().split()
    for x in s :
        print(x * int(m), end='')
    print()