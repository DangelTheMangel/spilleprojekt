import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class CarPlayer  extends Car {
    PApplet p;
    char leftKey;
    char leftKeyBig;
    char rightKey;
    char rightKeyBig;
    boolean D = false;
    boolean A = false;
    CarPlayer(PApplet p,PVector posit, PVector speed, PImage car, char leftKey, char leftKeyBig,char rightKey,char rightKeyBig) {

        super(p,posit, speed, car);
        this.p =p;
        this.leftKey = leftKey;
        this.leftKeyBig = leftKeyBig;
        this.rightKey = rightKey;
        this.rightKeyBig = rightKeyBig;
    }
    boolean collison = false;


    @Override
    void Movement() {

        posit.x += speed.x;
        posit.y += speed.y;

        //Lav noget med at den skal samle powerups. Det her bliver nok rodet.
        //Jeg ville nok lave en række if-statements Yanderedev agtigt.
        //Det ville være bedre at lave funktion som en datatype og lave en funkiton der tog en funktion som argument.
        //Caper

        //Lav noget med at den skal kunne falde af platformen.
    }

    @Override
    void drawCar() {

            p.fill(0, 0, 250);
            p.pushMatrix();
            if (rotating == true) {
                p.rectMode(p.CENTER);
                p.imageMode(p.CENTER);
                p.translate(posit.x, posit.y);
                p.rotate(speed.heading());
            }

            //p.rect(0, 0, 32, 16);
            p.image(car, 0,0);
            p.popMatrix();

            p.rectMode(p.CORNER);
    }

    void move() {
        if (p.keyPressed) {
            if (p.key == leftKey || p.key == leftKeyBig) {
                speed.x -= 2;
            }
            if (p.key == rightKey || p.key == rightKeyBig) {
                speed.x += 2;
            }
        }

    }

    void Controls() {


        if (p.keyPressed && p.key == rightKey || p.keyPressed && p.key == rightKeyBig) {
            D = true;
        }

        if (p.keyPressed && p.key == leftKey || p.keyPressed && p.key == leftKeyBig) {
            A = true;
        }

        if (A) {
            speed.rotate(-0.1f);
            rotating = true;
        } else if (D) {
            speed.rotate(0.1f);
        } else {
            speed.rotate(0);
        }


    }
    void keyreleased(){
        if (p.key == leftKey || p.key ==leftKeyBig) A = false;
        if (p.key == rightKey || p.key ==rightKeyBig) D = false;


    }




}
