import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class PowerUP {

    PApplet p;
    PImage PowerPhoto;
    PVector position;
    float frameCountStart;

    PowerUP(PApplet p, PImage PowerPhoto,PVector position){
        this.p = p;
        this.PowerPhoto = PowerPhoto;
        this.position = position;
        frameCountStart = p.frameCount;
    }

    void DrawPowerUp(){
        p.image(PowerPhoto , position.x , position.y);

    }

    public void Function(Car car ){}

    public void KillYouslef(ArrayList<PowerUP> pp, int i){
        if(p.frameCount > frameCountStart + 300){
            p.println("Casper siger n orde");
            pp.remove(i);
        }

    }




}
