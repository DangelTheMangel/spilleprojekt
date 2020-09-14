import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;

import java.util.ArrayList;

public class Core extends PApplet {
    public static void main(String[] args){ PApplet.main("Core");}
    Settings settings;
    Car car = new Car(new PVector(200,200),new PVector(1,2));
    @Override
    public void settings() {
        size(500,500);
    }

    ArrayList<CarCPU> CarCPUs = new ArrayList<CarCPU>();
    CarPlayer Player = new CarPlayer();
    public float arenaRadius;

    @Override
    public void setup() {

        settings = new Settings(this);
        car.p = this;
    }


    @Override
    public void draw() {
        settings.DrawSettings();
        car.Movement();
        car.drawCar();


        arenaRadius-=1;

        ellipse(arenaRadius,arenaRadius,height/2,height/2);
    }

    @Override
    public void mouseClicked() {
        settings.mouseClickedSettings();
    }
}


