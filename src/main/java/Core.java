import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;

import java.util.ArrayList;

public class Core extends PApplet {
    public static void main(String[] args){ PApplet.main("Core");}
  //  Settings settings;
    Car car = new Car(new PVector(250,200),new PVector(0,-2));

    @Override
    public void settings() { size(500,500); }

    ArrayList<CarCPU> CarCPUs = new ArrayList<CarCPU>();

    public float arenaRadius =500;

    @Override
    public void setup() {

      //  settings = new Settings(this);
        car.p = this;
    }


    @Override
    public void draw() {
            clear();
        //    settings.DrawSettings();

        fill(250,0,0);
        ellipse(height/2,width/2,arenaRadius,arenaRadius);
        car.Movement();

        car.drawCar();
        rect(100,50,50,50);




    }
    public void keyPressed(){
        car.pressing();
    }

//    @Override
  //  public void mouseClicked() {
  //      settings.mouseClickedSettings();
  //  }
}


