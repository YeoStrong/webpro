import urllib.request, urllib.parse, urllib.error
import xml.etree.ElementTree as ET

sum = 0
data = ""
fhand = urllib.request.urlopen(input('Enter location: '))
for line in fhand:
    data += line.decode()

commentinfo = ET.fromstring(data)
lst = commentinfo.findall('comments/comment')
print('Count:', len(lst))

for item in lst:
    sum += int(item.find('count').text)
print('Sum: ', sum)
