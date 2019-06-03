import turtle

from Tkinter import *
from turtle import *

from svglib.svglib import svg2rlg
from reportlab.graphics import renderPDF, renderPM

import canvasvg

painter = turtle.Turtle()

painter.pencolor("black")

painter.speed(0)

f = open("out1.txt", "r")

fl = f.readline()

screen = turtle.Screen()

print(screen.screensize())

screen.screensize(3000, 3000)

print(screen.screensize())

painter.hideturtle()
turtle.hideturtle()
turtle.update()
turtle.tracer(0, 0)
print(painter.isvisible())
color = 0;
idx = 0

tp = []
for c in fl:
    painter.seth((ord(c) - 30) * 36)
    painter.forward(10)
    b = ((float)(color%224) + 32)/255.0  # type: float
    r = ((float)((color/256)%224) + 32)/255.0    # type: float
    g = ((float)((color/(256**2)%256)))/255.0  # type: float
    if idx % 1000 == 0:
        print(idx/1000)
    if idx == 700:
        break
    idx = idx + 1
    painter.pencolor(r, g, b)
    color = color + 1


turtle.update()
print(1)
painter.hideturtle()
print(2)
print(3)
ts = painter.getscreen().getcanvas()
print(4)
filename = "img700"
print(5)
ts.postscript(filename + '.eps')
print(6)
img = Image.open(filename + '.eps')
print(7)
img.save(filename + '.png', 'png')
print(8)
turtle.done()
#canvasvg.saveall(filename + ".svg", ts.getcanvas())

#drawing = svg2rlg(filename + ".svg")
#renderPM.drawToFile(drawing, filename + ".png", "PNG")
