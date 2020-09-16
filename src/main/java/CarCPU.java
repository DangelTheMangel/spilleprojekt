import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class CarCPU extends Car{
    PApplet p;

    CarCPU(PApplet p, PVector posit, PVector speed, PImage car) {
        super(p,posit, speed, car);
        this.p =p;
    }


    void drawCar() {

        p.rect(0, 0, 32, 16);
        p.image(car, 0,0);

    }


    void Movement() {
        p.println("heheh bevægelse");
    }
}
