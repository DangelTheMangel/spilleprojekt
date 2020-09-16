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
    CarPlayer car ;
    CarCPU enemy;
    MainMenu menu;

    @Override
    public void settings() {
        size(640, 480);

    }


    ArrayList<CarCPU> CarCPUs = new ArrayList<CarCPU>();

    public float arenaRadius =500;

    @Override
    public void setup() {frameRate(60);
        print("w "+ width + "h " + height);
        playerCar = loadImage("dårligblå.png");
        EnemyCar = loadImage("grå.png");
        car = new CarPlayer(new PVector(250,200),new PVector(0,-1), playerCar);
        //enemy = new CarCPU(new PVector(250,200),new PVector(0,-1), EnemyCar);

        //  settings = new Settings(this);
        car.p = this;
        menu = new MainMenu(this, 1);
        arenaRadius =width;
        levelPic = loadImage("Moon.png");
        bagground = loadImage("Stars.png");
    }


    @Override
    public void draw() {

        car.Controls();

        if(!menu.btnPlay.erKlikket()) {
            menu.DrawMenu(bagground);

            print(menu.btnPlay.erKlikket());
        }else{
            clear();
            background(200);
            image(bagground,width/2,height/2, width, height );

            fill(250,0,0);
            ellipse(width/2,height/2,arenaRadius,arenaRadius);
            image(levelPic,width/2,height/2, arenaRadius,arenaRadius );

            car.Movement();
            car.drawCar();

            if(car.rotating){
                arenaRadius -= 0.2;
                car.collsion(arenaRadius);
            }else {
                arenaRadius = width;
            }
            if(car.collison){
                setup();
            }
        }
    }

//    @Override
     public void mouseClicked() {
         menu.MouseClickedMenu();
      }
}
