# "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
# O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
# 문제를 맞은 경우 그 문제의 점수는 
# 그 문제까지 연속된 O의 개수가 된다. 
# 예를 들어, 10번 문제의 점수는 3이 된다.
# "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
# OX퀴즈의 결과가 주어졌을 때, 
# 점수를 구하는 프로그램을 작성하시오.
n = int(input())
sum = 0
for _ in range(n) :
    a = input().split('X')
    for i in a :
        if i == "" :
            continue
        else :
            for j in range(1, 80) :
                if i == 'O'*j :
                    tempsum = j*(j+1)/2
                    sum += tempsum
    print(int(sum))
    sum = 0

# if a[i] == O*~~
# O = 1
# OO = 1 + 2
# OOO = 1 + 2 + 3
# for _ in range(n) :
