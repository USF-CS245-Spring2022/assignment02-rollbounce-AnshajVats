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

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }

    public BounceBalls(int x1, int y1, int valX, int getValY, int gravity, int  friction, int canvasWidth, int canvasHeight, int
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

    public void checkCollision() {

        if (posX1 - radius < 0)              // Left Wall?
        {
            posX1 = radius;              // Place ball against edge
            valX = (int)-(valX * friction * 0.5);
        }
        else if (posX1 + radius > canvasWidth) // Right Wall?
        {
            posX1 = canvasWidth - (radius * (friction +1));     // Place ball against edge
            valX =(int) -(valX * friction* 0.5);
        }
        else if(posY1 - radius < 0) {
            posY1 = 0;              // Place ball against edge
            valY = -(valY * friction);
        }
        else if(posY1 + radius > (canvasHeight-radius)) {
            posY1 = canvasHeight - (radius *(friction +1));
            valY = (int)-(valY* 0.5);
            bounce -= friction;
        }
    }
    public void move () {
        if(bounce != 0) {
            posX1 += valX;
            posY1 += valY;

            valY += gravity;
            checkCollision();
        }
        else {
            valX = 0;
            valY = 0;
        }
    }
    public int getPosX1() {
        return posX1;
    }

    public int getPosY1() {
        return posY1;
    }

    public int getValX() {
        return valX;
    }

    public int getGetValY() {
        return valY;
    }

    public void setPosX1(int posX1) {
        this.posX1 = posX1;
    }

    public void setPosY1(int posY1) {
        this.posY1 = posY1;
    }

    public void setValX(int valX) {
        this.valX = valX;
    }

    public void setGetValY(int getValY) {
        this.valY = getValY;
    }
}
