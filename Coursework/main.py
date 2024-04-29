file = open("land.txt", "r")
lines = file.readlines()
for line in lines:
    line = line.replace("\n", "")
file.close
