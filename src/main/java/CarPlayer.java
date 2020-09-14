import processing.core.PApplet;
import processing.core.PVector;

public class CarPlayer extends Car {
    PApplet p;

    CarPlayer(PVector P, PVector S) {
        super(P, S);
    }


    void move(){
        if(p.key == 'a' || p.key =='A'){
        speed.x-=2;
        }
        if(p.key == 'd' || p.key =='D'){
            speed.x+=2;
        }

    }

}
