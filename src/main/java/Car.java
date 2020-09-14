import processing.core.PApplet;
import processing.core.PVector;

public class Car {
    PApplet p;
    //movement
    PVector posit = new PVector(100, 200); //Position
    PVector speed = new PVector(0, 1); //Speed
    float sMulti; //Speed Multiplier (Det her skal bruges med speed powerups og sådan...

    //meta
    //  int points;

    Car(PVector posit, PVector speed) {
        this.posit = posit;
        this.speed = speed;
        sMulti = 1;

    }

    void Movement() {
        p.println("Movement", posit, speed.x, "sMulti=" + sMulti);
        posit.x += speed.x * sMulti;
        posit.y += speed.y * sMulti;

        //Lav noget med at den skal samle powerups. Det her bliver nok rodet.
        //Jeg ville nok lave en række if-statements Yanderedev agtigt.
        //Det ville være bedre at lave funktion som en datatype og lave en funkiton der tog en funktion som argument.
        //Caper

        //Lav noget med at den skal kunne falde af platformen.
    }

    void drawCar() {
        p.rect(posit.x, posit.y, 50, 50);

    }

    void pressing() {
        if (p.keyPressed) {
            if (p.key == 'a'||p.key =='A') {
                speed.rotate(1000);
            }
            if(p.key =='d'||p.key=='D'){
                speed.rotate(-1000);
            }

        }
    }
}