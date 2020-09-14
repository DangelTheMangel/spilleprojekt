import processing.core.PVector;

public class CarCPU{

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

