val S = Staging

clear
invisible()

// see http://www.geom.uiuc.edu/~daeron/docs/apidocs/java.awt.Color.html
// val colors = List(black, blue, cyan, gray,  green, magenta, darkGray, orange, pink, red, lightGray, yellow)

// val hours = List(3, 2, 1, 0, 11, 10, 9, 8, 7, 6, 5, 4) // start from 12 clock, 1, 2, ...
val hours = 0 to 11      // this will start from 3 o'clock, zero degree
val hr = 20
val cr = 100
val Pi2 = 2.0 * math.Pi // 2*Pi radians in a circle or 360 degree

S.ellipse(0,0,cr, cr)

def randomColor() = {
    val r = random(256)
    val g = random(256)
    val b = random(256)
    Color(r, g, b)   
}

val colors = {
    for (i <- hours) yield {
        val c = randomColor()
        c    
    }
}

val sg = hours.map(i => {
    val y = cr * math.sin(Pi2 * i/12) 
    val x = cr * math.cos(Pi2 * i/12)
    
    val t = S.point(x, y)
    t
})

S.loop {
    for(i <- hours) {
        var cm = colors(i)
        S.fill(cm)
        S.noStroke
        S.ellipse(sg(i), hr, hr)
        pause(0.5)             // wait() will not work    
    }
}