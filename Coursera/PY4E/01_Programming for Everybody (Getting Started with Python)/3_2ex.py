# try-except with ex3_1
hrs = input("Enter Hours:")
rate_str = input("Enter hourly rate:")
try:
    h = float(hrs)
    rate = float(rate_str)
except:
    print("Error, please enter numeric input")
if 0 < h <= 40:
    print(h*rate)
elif h > 40:
    print(40*rate+(h-40)*(rate*1.5))