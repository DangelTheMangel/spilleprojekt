import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class TeleporterPowerUp extends PowerUP {
    PApplet p;
    Core c;

    TeleporterPowerUp(PApplet p, PImage PowerPhoto, PVector position) {
        super(p, PowerPhoto, position);
        this.p = p;
    }

    public void Function(Car car ){
        car.posit.x = p.random(p.width*0.1f,p.width*0.9f); //ville være nice at tage cores arenaradius og bruge den her. -Casper
        car.posit.y = p.random(p.height*0.1f,p.height*0.9f);
        p.println("Fuck");
    }
}
