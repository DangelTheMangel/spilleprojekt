import processing.core.PVector;

public class Car {
    //movement
    PVector posit; //Position
    PVector speed; //Speed
    float sMulti; //Speed Multiplier (Det her skal bruges med speed powerups og sådan...

    //meta
    int points;

    Car(PVector P, PVector S){
        P = posit;
        S = speed;
    }
    void Movement(){
        posit.x += speed.x*sMulti;
        posit.y += speed.y*sMulti;
    }
}
