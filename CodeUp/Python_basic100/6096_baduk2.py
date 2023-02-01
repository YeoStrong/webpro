# 바둑판(19 * 19)에 흰 돌(1) 또는 검정 돌(0)이 모두 꽉 채워져 놓여있을 때,
# n개의 좌표를 입력받아 십(+)자 뒤집기한 결과를 출력하는 프로그램을 작성해보자.
n = int(input())
d = [[0 for j in range(20)] for i in range(20)]

for i in range(n) :
    x,y=input().split()
    for j in range(1, 20) :
        if d[j][int(y)]==0 :
            d[j][int(y)]=1
        else :
            d[j][int(y)]=0

        if d[int(x)][j]==0 :
            d[int(x)][j]=1
        else :
            d[int(x)][j]=0
        print(d[int(x)][int(y)])