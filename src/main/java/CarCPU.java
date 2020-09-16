import processing.core.PApplet;

import processing.core.PImage;

import processing.core.PVector;



public class CarCPU extends Car{

    PApplet p;
    float rotationMin, rotationMax, rotation;

    CarCPU(PApplet p, PVector posit, PVector speed, PImage car) {
        super(p,posit, speed, car);
        this.p =p;

        rotationMin = p.random(-0.5f,0f);
        rotationMax = p.random(0f,0.5f);
    }

    void drawCar() {

        p.pushMatrix();
            p.imageMode(p.CENTER);
            p.translate(posit.x, posit.y);
            p.rotate(speed.heading());
        p.image(car, 0,0);
        p.popMatrix();

    }

    void Movement() {
        speed.rotate(rotation);
        posit.x += speed.x * sMulti;
        posit.y += speed.y * sMulti;

        rotation = p.random(rotationMin,rotationMax);
    }

}