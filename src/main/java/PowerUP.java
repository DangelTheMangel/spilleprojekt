import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class PowerUP {

    PApplet p;
    PImage PowerPhoto;
    PVector position;
    PowerUP(PApplet p, PImage PowerPhoto,PVector position){
        this.p = p;
        this.PowerPhoto = PowerPhoto;
        this.position = position;
    }

    void DrawPowerUp(){
        p.image(PowerPhoto , position.x , position.y);

    }

    public void Function(Car car ){}






}
