import processing.core.PApplet;
import processing.core.PVector;

import java.util.Random;

public class CarCPU extends Car {
    PApplet p;
    float rotationMax, rotationMin, rotation;

    CarCPU(PVector P, PVector S) {
        super(P, S);
        rotationMin = p.random(-1f,0f);
        rotationMax = p.random(0f,1f);
    }

    @Override
    void Movement(){
        //Udregninger
        rotation = p.random(rotationMin,rotationMax);
        speed.rotate(rotation);

        //Visuelt
        p.rect(posit.x, posit.y, 50, 50);

        }

    @Override
    void drawCar() {
        p.fill(0,0,250);
        p.pushMatrix();
        if(rotating == true) {
            p.rectMode(p.CENTER);
            p.translate(posit.x, posit.y);
            p.rotate(speed.heading());
        }
        p.rect(0, 0, 50, 20);
        p.popMatrix();
    }

    @Override
    void collsion(float rad) {
        PVector lengthCar = new PVector(posit.x - p.width / 2, posit.y - p.height / 2);
        lengthCar.mag();
        p.line(p.width / 2, p.height / 2, p.width / 2 + lengthCar.x, p.height / 2 + lengthCar.y);

        if (rad / 2 < lengthCar.mag()) {
            p.println("Du Boomer");
        }
    }

}

/*Casper Tænker:
    Den skal gå tilfældige steder hen. Dette sker med at den tilføjer bestemte mængder af drej.
    Den gør det indenfor VARIABEL DREJ MAX og DREJ MIN, som er tilfældige. Det gør at biler drejer mere til den
    ene side end den anden.

    Den skal undgå kanten.
    Det er vel bare at se om den er RADIUS AF CIRKEL - BILENS LÆNGDE * 2.
    Og så vil den PANISKT DREJE ved at ÆNDRE DREJ TIL ET HØJT TAL.

    Den skal støde ind i alle powerups den kommer tæt på.
    Hvis RADIUS TIL POWERUP er mindre end BILENS LÆNGDE * 2
    Skal den DREJE MOD POWERUP.
    Dette fungerer nok på nogle if-statements, hvilket er dumt at have.

    DET VILLE OGSÅ VÆRE SJOVT HVIS AIS IKKE KUNNE TAGE POWERUPS, fordi så kørte de tilfældigt ind i dem.
    Og så har player også mulighed for at tage alle powerups.
 */

