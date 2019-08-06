import turtle
import canvasvg
import decimal


s = 19
steps = 100000

context = Context(prec=steps, rounding=ROUND_HALF_EVEN)
setcontext(context)

fl = str(Decimal(s).sqrt(context))
fl = fl.replace(".", "")

print(fl)

painter = turtle.Turtle()
painter.speed(0)

painter.hideturtle()
turtle.hideturtle()
turtle.update()
turtle.tracer(0, 0)

color = 0
idx = 0

for c in fl:
    painter.seth((ord(c) - 30) * 36)
    painter.forward(10)
    b = ((float)(color%224) + 32)/255.0  # type: float
    r = ((float)((color/256)%224) + 32)/255.0    # type: float
    g = ((float)((color/(256**2)%256)))/255.0  # type: float
    if idx % 1000 == 0:
        print(idx/1000)
    idx = idx + 1
    painter.pencolor(r, g, b)
    color = color + 1


turtle.update()
painter.hideturtle()
ts = painter.getscreen().getcanvas()
filename = "img900"
canvasvg.saveall(filename + ".svg", ts)