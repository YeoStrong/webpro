# 정수 3개를 입력받아 합과 평균을 출력해보자.
a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)
sum = a + b + c
avg = float(sum / 3)
print(sum, format(avg, ".2f"))