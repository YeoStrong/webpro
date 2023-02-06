# 어떤 사람의 C언어 성적이 주어졌을 때, 
# 평점은 몇 점인지 출력하는 프로그램을 작성하시오.
# A+: 4.3, A0: 4.0, A-: 3.7
# B+: 3.3, B0: 3.0, B-: 2.7
# C+: 2.3, C0: 2.0, C-: 1.7
# D+: 1.3, D0: 1.0, D-: 0.7
# F: 0.0
a = input()
unit = None
tenth = None
if a[0] == 'A' :
    unit = 4
elif a[0] == 'B' :
    unit = 3
elif a[0] == 'C' :
    unit = 2
elif a[0] == 'D' :
    unit = 1
elif a[0] == 'F' :
    unit = 0
    tenth = 0.0

if a[0] != 'F' :
    if a[1] == '+' :
        tenth = 0.3
    elif a[1] == '0' :
        tenth = 0.0
    elif a[1] == '-' :
        tenth = -0.3

print(unit + tenth)