import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class JesusPowerUp extends PowerUP {

    JesusPowerUp(PApplet p, PImage PowerPhoto, PVector position) {
        super(p, PowerPhoto, position);
    }

    @Override
    public void Function(Car car) {
        car.speed = car.speed.mult(30f);
    }
}
