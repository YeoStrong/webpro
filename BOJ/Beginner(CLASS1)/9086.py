# 문자열을 입력으로 주면 
# 문자열의 첫 글자와 마지막 글자를 
# 출력하는 프로그램을 작성하시오.
while True :
    try :
        str = input()
    except EOFError :
        break
    if str == "" :
        break
    for i in str :
        if ord(i)>90 or ord(i)<65 :
            break
        else :
            print(str[0] + str[len(str)-1])
            break