import re
name = input("Enter file:")
if len(name) < 1:
    name = "regex_sum_1735389.txt"
numlist = list()
sum = 0
    
handle = open(name)
for line in handle:
    line = line.rstrip()
    stuff = re.findall('[0-9]+', line)
    if len(stuff) < 1 :
        continue
    elif len(stuff) >= 1 :
        for i in stuff:
            numlist.append(int(i))

for j in numlist:
    sum += j
print(sum)

# try to make it in 1 line
# print(sum(map(int, re.findall('[0-9]+', open('regex_sum_1735389.txt', 'r').read()))))