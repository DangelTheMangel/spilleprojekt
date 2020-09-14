import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;

public class Core extends PApplet {
    public static void main(String[] args){ PApplet.main("Core");}
    Settings settings;
    Car car = new Car(new PVector(200,200),new PVector(1,2));
    @Override
    public void settings() {
        size(500,500);
    }

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


    }

    @Override
    public void mouseClicked() {
        settings.mouseClickedSettings();
    }
}


