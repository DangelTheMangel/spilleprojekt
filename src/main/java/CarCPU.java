import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class CarCPU  extends Car {
    PApplet p;


    CarCPU(PVector posit, PVector speed, PImage car) {
        super(posit, speed, car);
    }

    void Movement() {

        posit.x += speed.x * sMulti;
        posit.y += speed.y * sMulti;

        //Lav noget med at den skal samle powerups. Det her bliver nok rodet.
        //Jeg ville nok lave en række if-statements Yanderedev agtigt.
        //Det ville være bedre at lave funktion som en datatype og lave en funkiton der tog en funktion som argument.
        //Caper

        //Lav noget med at den skal kunne falde af platformen.

    }

    void drawCar() {

        p.image(car, 0,0);

    }

    void move() {


    }



    void collsion(float rad) {
        PVector lengthCar = new PVector(posit.x - p.width / 2, posit.y - p.height / 2);
        lengthCar.mag();
        p.line(p.width / 2, p.height / 2, p.width / 2 + lengthCar.x, p.height / 2 + lengthCar.y);


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

