# 평가를 문자(A, B, C, D, ...)로 입력받아 내용을 다르게 출력해보자.

# 평가 내용
# 평가 : 내용
# A : best!!!
# B : good!!
# C : run!
# D : slowly~
# 나머지 문자들 : what?
chr = input()
if chr == 'A' :
    print('best!!!')
elif chr == 'B' :
    print('good!!')
elif chr == 'C' :
    print('run!')
elif chr == 'D' :
    print('slowly~')
else :
    print('what?')