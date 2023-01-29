# Use the file name mbox-short.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
cnt = 0
sc = 0
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:"):
        continue
    line = float(line[line.find(':')+1:].strip())
    sc += line
    cnt += 1

print("Average spam confidence:",sc/cnt)