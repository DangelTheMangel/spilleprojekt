import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class Core extends PApplet {
    public static void main(String[] args){ PApplet.main("Core");}
    //  Settings settings;
    PImage playerCar ,EnemyCar;
    PImage levelPic;
    PImage bagground;
    PImage picklePower;
    AlmindeligKnap BackToMenu;
    PImage info;
    int antalBiler = 100;


    MainMenu menu;
    ArrayList<PowerUP> powerUps = new ArrayList<PowerUP>();
    ArrayList<Car> Monkeys = new ArrayList<Car>();

    @Override
    public void settings() {
        size(640, 480);
        noSmooth();

    }


    public float arenaRadius =500;

    @Override
    public void setup() {frameRate(60);
        Monkeys.clear();
        print("w "+ width + "h " + height);
        playerCar = requestImage("dårligblå.png");
        EnemyCar = requestImage("grå.png");
        info = requestImage("info_fall_cars.png");
        picklePower = requestImage("jesuspickel.png");
        BackToMenu = new AlmindeligKnap(this, width/2, height - height/12, width/2, height/12,"Back");



        menu = new MainMenu(this, 1);
        arenaRadius =height;
        levelPic = requestImage("MoonBIG.png");
        bagground = requestImage("Stars.png");
        powerUps.add(new PowerUP(this,picklePower,new PVector(width/2,height/2)));
        Monkeys.add(new CarPlayer( this, new PVector(250,200),new PVector(0,-2), playerCar, 'a','A','d','D'));
        Monkeys.add(new CarPlayer2( this, new PVector(200,200),new PVector(0,-2), playerCar, 'j','J','l','L'));

        for(int I=0; I<antalBiler; I++){
            Monkeys.add(new CarCPU(this, new PVector(random(100,400),random(100,400)),new PVector(0,-1), EnemyCar));
        }
    }


    @Override
    public void draw() {
        if(menu.settings.players = false){
            Monkeys.get(1).OVerTHEEdge = true;
        }

        Monkeys.get(0).Controls();


        if(!menu.btnPlay.erKlikket()) {
            menu.DrawMenu(bagground,info);
        }else{
            clear();

            image(bagground,width/2,height/2, width, height );
            winIf(0,1);
            winIf(1,0);
         {
                fill(0,0,0, 100);
                ellipse(width/2,height/2,arenaRadius,arenaRadius);
                image(levelPic,width/2,height/2, arenaRadius,arenaRadius );

                for(int i = 2; i<Monkeys.size();++i){
                    if(Monkeys.get(i).OVerTHEEdge ){
                        Monkeys.remove(i);
                    }
                }


                for(PowerUP pickle: powerUps){
                    pickle.DrawPowerUp();
                }
                if(menu.settings.multiplePlayers()){
                    Monkeys.get(1).Controls();
                    Monkeys.get(1).drawCar();
                    Monkeys.get(1).collision(Monkeys);
                }
                if(Monkeys.get(0).rotating){
                    arenaRadius -= 0.2;
                    for(PowerUP pickle: powerUps){
                        pickle.DrawPowerUp();
                    }

                    for(Car Bruh : Monkeys){
                        Bruh.Movement();
                        Bruh.drawCar();
                        Bruh.collision(Monkeys);
                        Bruh.OverEdge(arenaRadius);


                    }
                }else {
                    arenaRadius = width;
                }
                if(Monkeys.get(0).OVerTHEEdge && Monkeys.get(1).OVerTHEEdge)   {

                    setup();
                    Monkeys.get(0).OVerTHEEdge = false;

                }
            }


        }
    }

    //    @Override
    public void mouseClicked() {
        menu.MouseClickedMenu();
        BackToMenu.registrerKlik(mouseX,mouseY);
    }
    public void keyReleased(){
        for(Car Bruh : Monkeys) {
            println("taber");
            Bruh.keyreleased();
        }
    }

    public void winIf(int player, int modstanderplayer){
        if(Monkeys.size() == 2 && Monkeys.get(player).OVerTHEEdge == false && Monkeys.get(modstanderplayer).OVerTHEEdge == true){
            if(BackToMenu.erKlikket()){
                setup();
                BackToMenu.registrerRelease();
            }
            Monkeys.get(0).rotating = false;
            text("you Won!", 10,10);
            BackToMenu.tegnKnap();

        }
    }
    public void PpCollision(){
        for(int i =0 ; i < Monkeys.size();++i){
            for(int j = 0; j < powerUps.size(); ++j){
                if(Monkeys.get(i).posit.x == 1)
            }
        }
    }

}