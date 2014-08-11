# Clock

## Intent
We want to find a way to express the time passess us continuously. 

For the programming, the purpose of this exercise is to learn how to use map function. In the base version, we 

- Used trigonometry to calculate the position and size,
- Used jave's color library to create customer color,
- Used random number function to generate color components.

## Staging
One of the problems of base version of clock, is the turtle draw the circle (circumference) from its current position, it means current posistion is not the center of circle. This makes hard to calculate the position of each circle and texts are not centered in the circle, the following diagram shows the challenge.  

```
	// with turtle
    t.circle(hr); write("00")
    // with Staging
    S.ellipse(t.position, hr, hr); S.text("11", t.position)
```

<==insert screenshot here==>

Kojo provides a api to draw difference shapes in [Staging library](https://code.google.com/p/kojo/wiki/StagingModule). We can use ellipse to draw circle, S.ellipse(x, y, rx, ry) or S.ellipse(point, rx, ry). We still do not want to deal with the text position problem for now, and we will use different way to the elapse of time.

- add S.loop, which is different from while(true); it does not block the scope.
- If we want to give a sense of time moving by changing circle color, we cannot use random colors. We have to use a fix set of colors. 

