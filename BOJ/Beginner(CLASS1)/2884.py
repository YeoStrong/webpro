# 45분 일찍 알람 설정하기
h, m = map(int, input().split())
if m >= 45 :
    print(h,m-45)
else :
    if h > 0 :
        print(h-1, m+15)
    else :
        print(h+23, m+15)