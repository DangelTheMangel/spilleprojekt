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
    AlmindeligKnap BackToMenu;
    PImage info;

    MainMenu menu;

    ArrayList<Car> Monkeys = new ArrayList<Car>();

    @Override
    public void settings() {
        size(640, 480);

    }


    public float arenaRadius = height;

    @Override
    public void setup() {frameRate(60);
        Monkeys.clear();
        print("w "+ width + "h " + height);
        playerCar = requestImage("dårligblå.png");
        EnemyCar = requestImage("grå.png");
        info = requestImage("info_fall_cars.png");
        BackToMenu = new AlmindeligKnap(this, width/2, height - height/12, width/2, height/12,"Back");



        menu = new MainMenu(this, 1);
        arenaRadius =height;
        levelPic = requestImage("MoonBIG.png");
        bagground = requestImage("Stars.png");

        Monkeys.add(new CarPlayer( this, new PVector(250,200),new PVector(0,-4), playerCar));
        for(int I=0; I<50; I++){
            Monkeys.add(new CarCPU(this, new PVector(random(100,400),random(100,400)),new PVector(0,-4), EnemyCar));
        }
    }


    @Override
    public void draw() {

        Monkeys.get(0).Controls();

        if(!menu.btnPlay.erKlikket()) {
            menu.DrawMenu(bagground,info);
        }else{
            clear();

            image(bagground,width/2,height/2, width, height );

            if(Monkeys.size() == 1 && Monkeys.get(0).OVerTHEEdge == false){
                if(BackToMenu.erKlikket()){
                    setup();
                    BackToMenu.registrerRelease();
                }
                Monkeys.get(0).rotating = false;
                text("you Won!", 10,10);
                BackToMenu.tegnKnap();

            }{
                fill(0,0,0, 100);
                ellipse(width/2,height/2,arenaRadius,arenaRadius);
                image(levelPic,width/2,height/2, arenaRadius,arenaRadius );

                for(int i = 1; i<Monkeys.size();++i){
                    if(Monkeys.get(i).OVerTHEEdge){
                        Monkeys.remove(i);
                    }
                }



                if(Monkeys.get(0).rotating){
                    arenaRadius -= 0.2;
                    for(Car Bruh : Monkeys){
                        Bruh.Movement();
                        Bruh.drawCar();
                        Bruh.collision(Monkeys);
                        Bruh.OverEdge(arenaRadius);
                    }
                }else {
                    arenaRadius = width;
                }
                if(Monkeys.get(0).OVerTHEEdge){

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
}