import processing.core.PApplet;
import processing.core.PVector;

public abstract class Car {
    PApplet p;
    //movement
    boolean rotating = false;
    PVector posit = new PVector(100, 200); //Position
    PVector speed = new PVector(0, 1); //Speed
    float sMulti; //Speed Multiplier (Det her skal bruges med speed powerups og sådan...

    //meta
    //  int points;

    Car(PVector posit, PVector speed) {
        this.posit = posit;
        this.speed = speed;
        sMulti = 1;

    }

    abstract void Movement();

   abstract void drawCar();

     abstract void collsion(float rad);
    }

