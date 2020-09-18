import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class JesusPowerUp extends PowerUP {

    JesusPowerUp(PApplet p, PImage PowerPhoto, PVector position) {
        super(p, PowerPhoto, position);
    }

    @Override
    public void Function(Car car) {
        car.posit.x = p.random(p.width,p.width);
        car.posit.y = p.random(p.height,p.height);
    }
}
