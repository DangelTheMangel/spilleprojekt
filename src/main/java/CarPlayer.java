import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class CarPlayer  extends Car {
    PApplet p;


    CarPlayer(PApplet p,PVector posit, PVector speed, PImage car) {
        super(p,posit, speed, car);
    }
    boolean collison = false;


    @Override
    void Movement() {

        posit.x += speed.x * sMulti;
        posit.y += speed.y * sMulti;

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
            if (p.key == 'a' || p.key == 'A') {
                speed.x -= 2;
            }
            if (p.key == 'd' || p.key == 'D') {
                speed.x += 2;
            }
        }

    }

    void Controls() {
        boolean D = false;
        boolean A = false;

        if (p.keyPressed && p.key == 'd' || p.keyPressed && p.key == 'D') {
            D = true;
        }

        if (p.keyPressed && p.key == 'a' || p.keyPressed && p.key == 'A') {
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


    void collsion(float rad) {
        PVector lengthCar = new PVector(posit.x - p.width / 2, posit.y - p.height / 2);
        lengthCar.mag();
        p.line(p.width / 2, p.height / 2, p.width / 2 + lengthCar.x, p.height / 2 + lengthCar.y);

        if (rad / 2 < lengthCar.mag()) {
            collison = true;
        }
    }
}
