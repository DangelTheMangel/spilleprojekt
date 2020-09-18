import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Amper extends PowerUP {
    PApplet p;

    Amper(PApplet p, PImage PowerPhoto, PVector position) {
        super(p, PowerPhoto, position);
        this.p = p;
    }

    public void Function(Car car ){
        car.speed = car.speed.mult(2);
        p.println("SLURP AMPER MMHH");
    }
}