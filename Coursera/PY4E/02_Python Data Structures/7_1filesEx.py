# Use words.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
fstr = fh.read().upper().rstrip()
print(fstr)