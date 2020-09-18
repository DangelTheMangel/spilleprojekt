import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class PowerUP {
    PApplet p;
    PImage PowerPhoto;
    PVector Postion;
    PowerUP(PApplet p, PImage PowerPhoto,PVector Postion ){
        this.p = p;
        this.PowerPhoto = PowerPhoto;
        this.Postion = Postion;
    }

    void DrawPowerUp(){
        p.image(PowerPhoto , Postion.x , Postion.y);

    }



}
