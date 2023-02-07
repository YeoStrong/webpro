# 입력 받은 대로 출력하는 프로그램을 작성하시오.
# 입력 : 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다. 
# 각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다. 
# 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.
while True:
    try :
        x = input()
    except EOFError :
        break
    if x == "" :
        break
    else :
        print(x)