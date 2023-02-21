# N개의 수가 주어졌을 때, 
# 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

# 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 
# 둘째 줄부터 N개의 줄에는 수가 주어진다. 
# 이 수는 10,000보다 작거나 같은 자연수이다.
import sys

n = int(sys.stdin.readline())
num_list = [0] * 10001
for _ in range(n):
    num_list[int(sys.stdin.readline())] += 1
for i in range(10001):
    if num_list[i] != 0:
        for _ in range(num_list[i]):
            print(i)
# for i in range(n):
#     i = (sys.stdin.readline().rstrip())
    

# b = sorted(a)
# for i in b:
#     sys.stdout.write(i+"\n")