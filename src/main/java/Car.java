import processing.core.PApplet;

import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;


public class Car {
    PApplet p;

    //movement
    boolean D = false;
    boolean A = false;
    boolean rotating = false;
    float carSize = 20;
    float minDist;
    float speedLoss = (float) 0.05;
    PVector posit = new PVector(100, 200); //Position

    PVector speed = new PVector(0, 1); //Speed

    PImage car;
    ArrayList<PowerUP> pp;
    boolean OVerTHEEdge;

    //meta

    //  int points;



    Car(PApplet p,PVector posit, PVector speed, PImage car) {
        this.p =p;
        this.posit = posit;

        this.speed = speed;
        this.car = car;
    }



    void Movement() {

        p.println("Movement", posit, speed.x, "sMulti=");

        posit.x += speed.x;

        posit.y += speed.y;


        //Lav noget med at den skal samle powerups. Det her bliver nok rodet.
        //Jeg ville nok lave en række if-statements Yanderedev agtigt.
        //Det ville være bedre at lave funktion som en datatype og lave en funkiton der tog en funktion som argument.
        //Caper

        //Lav noget med at den skal kunne falde af platformen.



    }

    void collision( ArrayList<Car> monkeys ){
        for (int i = 0; i < monkeys.size(); i++) {
            if (this.posit.x != monkeys.get(i).posit.x || this.posit.y != monkeys.get(i).posit.y) {

                    float dx = monkeys.get(i).posit.x - this.posit.x;
                    float dy = monkeys.get(i).posit.y - this.posit.y;

                    float distance = p.dist(this.posit.x, this.posit.y, monkeys.get(i).posit.x, monkeys.get(i).posit.y);  //nuværende distance mellem to bolde

                    minDist = this.carSize + 2;

                    if (distance <= minDist) {  //basically, "hvis boldene kommer inden for hinandens radius
                        float angle = p.atan2(dy, dx);  //find vinkel mellem bolde

                        float targetX = this.posit.x + p.cos(angle) * minDist;  //koordinater splittes fra nu af op i x- og y-komposanter, fordi x bruger cos() og y bruger sin()
                        float targetY = this.posit.y + p.sin(angle) * minDist;  //

                        float newX = (targetX - monkeys.get(i).posit.x) * speedLoss;  //beregner hvor meget fart en bold vil miste/modtage
                        float newY = (targetY - monkeys.get(i).posit.y) * speedLoss;  //

                        speed.x -= newX;      //
                        speed.y -= newY;      //finder ny hastighed for begge bolde, der støder sammen
                        monkeys.get(i).speed.x += newX; //
                        monkeys.get(i).speed.y += newY; //

                         }
                }

            }
        }

    void OverEdge(float rad){
        PVector lengthCar = new PVector(posit.x - p.width / 2, posit.y - p.height / 2);
        lengthCar.mag();
        p.line(p.width / 2, p.height / 2, p.width / 2 + lengthCar.x, p.height / 2 + lengthCar.y);

        if (rad / 2 < lengthCar.mag()) {
            OVerTHEEdge = true;
        }
    }


    void drawCar() {
        p.fill(0,0,250);
        p.pushMatrix();

        if(rotating) {
            p.rectMode(p.CENTER);
            p.translate(posit.x, posit.y);
            p.rotate(speed.heading());
        }
        p.rect(0, 0, 50, 20);
        p.popMatrix();
    }




//boomer
    void Controls() { //Noget går galt her når man trykker på begge knapper på samme tid,
                      // og vi skal have noget der tjekker om det sker og gør noget ved det.
        if (p.keyPressed) {
                if(p.keyPressed & p.key == 'd'){
                    D=true;
                }
                if(p.keyPressed & p.key == 'a'){
                    A=true;
                }
                if(A){
                    speed.rotate(-0.1f);
                    rotating = true;
                }
                else if(D){
                speed.rotate(0.1f);}
                else{
                speed.rotate(0);}
            }

        }
    void keyreleased(){
        if (p.key == 'd' || p.key =='D') A = false;
        if (p.key == 'a' || p.key =='A') D = false;
    }
}

//AMPER: this.speed = this.speed.mult(2);