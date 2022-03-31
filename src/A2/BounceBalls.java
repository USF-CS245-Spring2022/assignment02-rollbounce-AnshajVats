package A2;

import java.awt.*;

public class BounceBalls {
    protected int posX1;
    protected int posY1;
    protected int valX;
    protected int valY;
    protected int bounce;
    protected int friction;
    protected int gravity;
    protected int canvasWidth, canvasHeight;
    protected int radius;
    protected Color col;

    /**
     * @return the color of the ball
     */
    public Color getCol() {
        return col;
    }

    /**
     * @param col sets the colour of the ball
     */
    public void setCol(Color col) {
        this.col = col;
    }

    /**
     * @param x1           x-axis of the ball
     * @param y1           y-axis of the ball
     * @param valX         velocity on x-axis
     * @param getValY      velocity on y-axis.
     * @param gravity      gravity given in the property file
     * @param friction     friction given in the property file
     * @param canvasWidth  window_width canvasWidth given in the property file
     * @param canvasHeight window_height given in the property file
     * @param radius       radius of the ball  given in the property file
     */
    public BounceBalls(int x1, int y1, int valX, int getValY, int gravity, int friction, int canvasWidth, int canvasHeight, int
            radius) {
        this.posX1 = x1;
        this.posY1 = y1;
        this.valX = valX;
        this.bounce = gravity;
        this.friction = friction;
        this.gravity = gravity;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.radius = radius;
        valY = 0;
    }

    /**
     * If the collision happen on the x or y-axis. This method will change the direction of the ball
     * Changes the speed of the ball.
     */

    public void checkCollision() {

        if (posX1 - radius < 0)              // Left Wall?
        {
            posX1 = radius;              // Place ball against edge
            valX = (int) -(valX * friction * 0.5);
        } else if (posX1 + radius > (canvasWidth - radius)) // Right Wall?
        {
            posX1 = canvasWidth - (radius - (radius / 2));     // Place ball against edge
            valX = (int) -(valX * friction * 0.5);
        } else if (posY1 - radius < 0) {
            posY1 = 0;              // Place ball against edge
            valY = -(valY * friction);
        } else if (posY1 + radius > (canvasHeight - radius)) {
            posY1 = canvasHeight - (radius * 3);
            valY = (int) -(valY * 0.5);
            bounce -= friction;
        }
    }

    /**
     * This method will move the ball in x and y plane with  some given velocity
     */
    public void move() {
        if (bounce != 0) {
            posX1 += valX;
            posY1 += valY;

            valY += gravity;
            checkCollision();
        } else {
            valX = 0;
            valY = 0;
        }
    }

    /**
     * @return the position of x
     */
    public int getPosX1() {
        return posX1;
    }

    /**
     * @return the position of y
     */
    public int getPosY1() {
        return posY1;
    }

    /**
     * @return the velocity of x
     */
    public int getValX() {
        return valX;
    }

    /**
     * @return the velocity of y
     */
    public int getGetValY() {
        return valY;
    }

    /**
     * @param posX1 set the position of x
     */
    public void setPosX1(int posX1) {
        this.posX1 = posX1;
    }

    /**
     * @param posY1 set the position of y
     */
    public void setPosY1(int posY1) {
        this.posY1 = posY1;
    }

    /**
     * @param valX set the velocity of x
     */
    public void setValX(int valX) {
        this.valX = valX;
    }

    /**
     * @param getValY set the velocity of y
     */
    public void setGetValY(int getValY) {
        this.valY = getValY;
    }
}
