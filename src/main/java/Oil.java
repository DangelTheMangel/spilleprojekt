import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Oil extends PowerUP{
    Oil(PApplet p, PImage PowerPhoto, PVector position) {
        super(p, PowerPhoto, position);
    }

    @Override
    public void Function(Car car) {
        car.speed = car.speed.mult(0.5f);
    }
}
