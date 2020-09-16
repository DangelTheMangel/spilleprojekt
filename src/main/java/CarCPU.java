import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class CarCPU extends Car{
    PApplet p;
    float turnMin, turnMax, turn;

    CarCPU(PApplet p, PVector posit, PVector speed, PImage car) {
        super(p,posit, speed, car);
        this.p =p;
        turnMax = p.random(0.5f,0f);
        turnMin = p.random(0f,-0.5f);
    }


    void drawCar() {

        p.rect(0, 0, 32, 16);
        p.image(car, 0,0);

    }


    void Movement() {
        turn = p.random(turnMax,turnMin);
        p.println("heheh bevægelse");
    }
}
