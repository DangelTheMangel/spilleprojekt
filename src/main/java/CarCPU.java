import processing.core.PApplet;

import processing.core.PImage;

import processing.core.PVector;



public class CarCPU extends Car{

    PApplet p;
    float rotationMin, rotationMax, rotation;

    CarCPU(PApplet p, PVector posit, PVector speed, PImage car) {
        super(p,posit, speed, car);
        this.p =p;

        rotationMin = p.random(-1f,0f);
        rotationMax = p.random(0f,1f);
    }





    void drawCar() {
        p.image(car, posit.x,posit.y);
    }

    void Movement() {
        speed.rotate(rotation);
        posit.x += speed.x * sMulti;
        posit.y += speed.y * sMulti;

        rotation = p.random(rotationMin,rotationMax);
    }

}