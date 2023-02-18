n = int(input())
a = []
b = []
for _ in range(n):
    a.append(int(input()))
for i in a:
    if i > 0 :
        b.append(i)
    elif i == 0 :
        del b[-1]
print(sum(b))