# 알파벳 대소문자로 된 단어가 주어지면, 
# 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
# 단, 대문자와 소문자를 구분하지 않는다.
a = input().upper()
b = {}
cnt = 0
for i in a:
    if i in b:
        b[i] += 1
    else:
        b[i] = 1

for i in b.values():
    if i == max(b.values()):
        cnt += 1

if cnt == 1:
    print(max(b, key=b.get).upper())
else :
    print("?")