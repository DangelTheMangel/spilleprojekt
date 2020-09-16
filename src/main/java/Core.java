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

    MainMenu menu;

    ArrayList<Car> Monkeys = new ArrayList<Car>();

    @Override
    public void settings() {
        size(640, 480);

    }


    public float arenaRadius =500;

    @Override
    public void setup() {frameRate(60);
        print("w "+ width + "h " + height);
        playerCar = requestImage("dårligblå.png");
        EnemyCar = requestImage("grå.png");



        menu = new MainMenu(this, 1);
        arenaRadius =height;
        levelPic = requestImage("MoonBIG.png");
        bagground = requestImage("Stars.png");

        Monkeys.add(new CarPlayer( this, new PVector(250,200),new PVector(0,-4), playerCar));
        for(int I=0; I<10; I++){
            Monkeys.add(new CarCPU(this, new PVector(random(100,400),random(100,400)),new PVector(0,-1), EnemyCar));
        }
    }


    @Override
    public void draw() {

        Monkeys.get(0).Controls();

        if(!menu.btnPlay.erKlikket()) {
            menu.DrawMenu(bagground);
        }else{
            clear();
            background(200);
            image(bagground,width/2,height/2, width, height );

            fill(0,0,0, 100);
            ellipse(width/2,height/2,arenaRadius,arenaRadius);
            image(levelPic,width/2,height/2, arenaRadius,arenaRadius );



            for(Car Bruh : Monkeys){
                Bruh.Movement();
                Bruh.drawCar();
                Bruh.collision(Monkeys);
            }

            if(Monkeys.get(0).rotating){
                arenaRadius -= 0.2;
                Monkeys.get(0).OverEdge(arenaRadius);
            }else {
                arenaRadius = width;
            }
            if(Monkeys.get(0).OVerTHEEdge){
                setup();
            }
        }
    }

//    @Override
     public void mouseClicked() {
         menu.MouseClickedMenu();
      }
}
