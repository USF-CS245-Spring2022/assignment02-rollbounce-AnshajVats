I build the canvas based on the ratio provided to us by the property file.The first thing I do is call
the RollBounce contractor read all the input from the property file and generate random starting positions
for each ball and random speed for each ball. Also generated random colours foreach balls. I stored all this
information in the BounceBall class. I also added the BounceBall class to the linkList. After that I called the
move method for each ball. Move is th method present in the BounceBall class. In move method I call checkCollision
which checks for any collision with the edge. if there is a collision on x-axis. It changes the direction of the ball
and the position of x by (canvasWidth - (radius - (radius / 2))). Similarly, on the y-axis it changes the y position
by canvasHeight - (radius * 3). I repeat this for every ball. The implement gravity and friction by making velocity
on y-axis zero. As it falls down it accelerates by gravity and as the ball goes up it decelerate by gravity. Also,
friction reduces the speed of the ball every time it bounces.

