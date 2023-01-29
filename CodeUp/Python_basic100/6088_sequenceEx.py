# 등차(차이가 같다의 한문 말) 수열이라고 한다. (등차수열 : arithmetic progression/sequence)

# "그럼.... 123번째 나오는 수는 뭘까?"

# 시작 값(a), 등차(d), 몇 번째인지를 나타내는 정수(n)가 입력될 때
# n번째 수를 출력하는 프로그램을 만들어보자.
a, d, n = input().split()
a = int(a)
d = int(d)
n = int(n)
seq = a + d * (n-1)
print(seq)