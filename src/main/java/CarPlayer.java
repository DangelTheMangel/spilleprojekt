import processing.core.PApplet;
import processing.core.PVector;

public class CarPlayer  extends Car {
    PApplet p;

    CarPlayer(PVector posit, PVector speed) {
        super(posit, speed);
    }


    void move(){
        if(p.keyPressed) {
            if (p.key == 'a' || p.key == 'A') {
                speed.x -= 2;
            }
            if (p.key == 'd' || p.key == 'D') {
                speed.x += 2;
            }
        }

    }

}
