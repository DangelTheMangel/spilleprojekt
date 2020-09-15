import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Core extends PApplet {
    public static void main(String[] args){ PApplet.main("Core");}
    //  Settings settings;
    CarPlayer car = new CarPlayer(new PVector(250,200),new PVector(0,-1));
    MainMenu menu;

    @Override
    public void settings() { size(640, 480); }

    ArrayList<CarCPU> CarCPUs = new ArrayList<CarCPU>();

    public float arenaRadius =500;

    @Override
    public void setup() {

        //  settings = new Settings(this);
        car.p = this;
        menu = new MainMenu(this, 1);
        arenaRadius =width;
    }


    @Override
    public void draw() {

        menu.DrawMenu();


        if(menu.btnPlay.erKlikket()){

            clear();
            background(200);
            //    settings.DrawSettings();

            fill(250,0,0);
            ellipse(width/2,height/2,arenaRadius,arenaRadius);
            car.Movement();

            car.drawCar();
            rect(100,50,50,50);
            car.collsion(arenaRadius);

            if(car.rotating){
                arenaRadius -= 0.2;
            }

            if(car.collison){
                car.rotating = false;
                menu.btnPlay.registrerRelease();
                car.collison = false;
                exit();
            }

        }



    }
    public void keyPressed(){
        car.Controls();
    }

//    @Override
     public void mouseClicked() {
         menu.MouseClickedMenu();
      }
}
