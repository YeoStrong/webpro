# 정수(0 ~ 100) 1개를 입력받아 0부터 그 수까지 순서대로 출력해보자.

# range(n) 은 0, 1, 2, ... , n-2, n-1 까지의 수열을 의미한다.
# 예를 들어 range(3) 은 0, 1, 2 인 수열을 의미한다.
# range(끝)
# range(시작, 끝)
# range(시작, 끝, 증감)

# for i in range(n) :    #range(n)에 들어있는(in) 각 수에 대해서(for) 순서대로 i에 저장해 가면서...
# 이때의 for는 각각의 값에 대하여... 라는 for each 의 의미각의를 가진다고 생각할 수 있다.
n = int(input())
for i in range(n+1) :
    print(i)