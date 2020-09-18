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
    PImage picklePower,amperPower, stonePower, teleporterPower, oilPower ;

    AlmindeligKnap BackToMenu;
    PImage info;
    int antalBiler = 1;


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
        loadPic();
        BackToMenu = new AlmindeligKnap(this, width/2, height - height/12, width/2, height/12,"Back");
        menu = new MainMenu(this, 1);
        arenaRadius =height;


        Monkeys.add(new CarPlayer( this, new PVector(250,200),new PVector(0,-2), playerCar, 'a','A','d','D'));
        Monkeys.add(new CarPlayer2( this, new PVector(200,200),new PVector(0,-2), playerCar, 'j','J','l','L'));
        spawnPowerUp();
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
            PpCollision();

         {
                fill(0,0,0, 100);
                ellipse(width/2,height/2,arenaRadius,arenaRadius);
                image(levelPic,width/2,height/2, arenaRadius,arenaRadius );

                for(int i = 2; i<Monkeys.size();++i){
                    if(Monkeys.get(i).OVerTHEEdge ){
                        Monkeys.remove(i);
                    }
                }

             spawnPowerUp();
                for(int i = 0 ; i < powerUps.size(); ++i){
                    PowerUP pickle = powerUps.get(i);
                    pickle.DrawPowerUp();
                    pickle.KillYouslef(powerUps, i);
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
            //println("taber");
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

        for (int i =0 ; i < Monkeys.size();++i){

            for(int j = 0; j < powerUps.size(); ++j){
                println("car" + Monkeys.get(i).posit.x + ";" + Monkeys.get(i).posit.x + "Pickel: " + powerUps.get(j).position.x + ";" + powerUps.get(j).position.x);
                if(Monkeys.get(i).posit.x >powerUps.get(j).position.x
                        &&Monkeys.get(i).posit.x <powerUps.get(j).position.x+32&&
                        Monkeys.get(i).posit.y >powerUps.get(j).position.y
                        &&Monkeys.get(i).posit.y < powerUps.get(j).position.y+32){
                        powerUps.get(j).Function(Monkeys.get(i));
                        powerUps.remove(j);
                }
            }
        }
    }

    public void spawnPowerUp(){
        int ppNumb = (int) random(0,1000);
        println(ppNumb);
        if(ppNumb == 1){
            powerUps.add( new JesusPowerUp(this,picklePower,new PVector(random(width*0.1f,width*0.9f),random(height*0.1f,height*0.9f))));
        }

        if(ppNumb == 2){
            powerUps.add(new Amper(this,amperPower,new PVector(random(width*0.1f,width*0.9f),random(height*0.1f,height*0.9f))));
        }
        if(ppNumb == 3){
            powerUps.add(new StonePowerUP(this,stonePower, new PVector( random(width*0.1f,width*0.9f),random(height*0.1f,height*0.9f))));
        }
        if(ppNumb == 4){
            powerUps.add(new TeleporterPowerUp(this, teleporterPower, new PVector( random(width*0.1f,width*0.9f),random(height*0.1f,height*0.9f)) ));
        }

        if(ppNumb == 5){
            powerUps.add(new Oil(this, oilPower, new PVector( random(width*0.1f,width*0.9f),random(height*0.1f,height*0.9f))));

        }
    }

    void loadPic(){
        playerCar = requestImage("dårligblå.png");
        EnemyCar = requestImage("grå.png");
        info = requestImage("info_fall_cars.png");
        picklePower = requestImage("jesuspickel.png");
        amperPower = requestImage("Amper.png");
        stonePower = requestImage("Stone.png");
        teleporterPower = requestImage("Teleporter.png");
        oilPower = requestImage("Oil.png");
        levelPic = requestImage("MoonBIG.png");
        bagground = requestImage("Stars.png");

    }

}