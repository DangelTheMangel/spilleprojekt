import processing.core.PApplet;
import processing.core.PVector;

public class Car {
    PApplet p;
    //movement
    PVector posit = new PVector(0,0); //Position
    PVector speed = new PVector(0,0); //Speed
    float sMulti; //Speed Multiplier (Det her skal bruges med speed powerups og sådan...

    //meta
  //  int points;

    Car(PVector P, PVector S){
        P = posit;
        S = speed;
     //   sMulti = 1;

    }
    void Movement(){
        posit.x += speed.x*sMulti;
        posit.y += speed.y*sMulti;
        //Lav noget med at den skal samle powerups. Det her bliver nok rodet.
        //Jeg ville nok lave en række if-statements Yanderedev agtigt.
        //Det ville være bedre at lave funktion som en datatype og lave en funkiton der tog en funktion som argument.
        //Caper

        //Lav noget med at den skal kunne falde af platformen.
    }
   void drawCar(){
        p.rect(posit.x,posit.y,50,50);

    }
}
