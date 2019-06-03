from PIL import Image
from math import sqrt
from math import floor

wimg = Image.new('RGB', (1000,1000), "white")

pix = wimg.load()

f = open("letters", "r")

frl = f.readlines()

for x in range(1000):
    for y in range(1000):
        if frl[x][y] == frl[y][x]:
            r = ord(frl[x][y]) - 97
            dist = int(floor(sqrt((y - 501) ** 2 + (x - 825) ** 2) * 0.12)) - 80
            c = 9
            pix[x,y] = (c*r, c*r, c*r)

for i in range (823, 829):
    pix[i, 501] = (255,255,255)

wimg.show()
wimg.save("root19c.png", 'PNG')
