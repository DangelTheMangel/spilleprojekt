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

        p.rect(0, 0, 32, 16);
        p.image(car, posit.x,posit.y);

    }


    void Movement() {
        p.println("heheh bevægelse");
        rotation = p.random(rotationMin,rotationMax);
        speed.rotate(rotation);

        rotation = p.random(rotationMin,rotationMax);
        speed.rotate(rotation);
    }
}
