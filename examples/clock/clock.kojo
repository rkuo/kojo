// import Staging._

clear
invisible()

// see http://www.geom.uiuc.edu/~daeron/docs/apidocs/java.awt.Color.html
val colors = List(black, blue, cyan, gray,  green, magenta, darkGray, orange, pink, red, lightGray, yellow)

// val hours = List(3, 2, 1, 0, 11, 10, 9, 8, 7, 6, 5, 4) // start from 12 clock, 1, 2, ...
val hours = 0 to 11      // this will start from 3 o'clock
val hr = 20
val cr = 100
val Pi2 = 2.0 * math.Pi // 2*Pi radians in a circle or 360 degree

setAnimationDelay(100)

// drawHour(0,0,cr)

def randomColor() = {
    val r = random(256)
    val g = random(256)
    val b = random(256)
    Color(r, g, b)   
}

val sg = hours.map(i => {
    val y = cr * math.sin(Pi2 * i/12) 
    val x = cr * math.cos(Pi2 * i/12)
    val cm = randomColor  
    
    val t = newTurtle(x, y)
    t.invisible()
    t.setFillColor(cm)     // or use t.setFillColor(colors(i))
    t.setPenColor(cm)
    t.setPenThickness(1)

    t.circle(hr)
    t
})

sg.foreach(t => {
    t.setFillColor(white)
    t.circle(hr)
    pause(0.1)         // wait() will not work
    t.setFillColor(randomColor)
    t.circle(hr)
})
