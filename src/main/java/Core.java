import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;

public class Core extends PApplet {
    public static void main(String[] args){ PApplet.main("Core");}
    Settings settings;

    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
       settings = new Settings(this);
    }


    @Override
    public void draw() {
        settings.DrawSettings();

    }

    @Override
    public void mouseClicked() {
        settings.mouseClickedSettings();
    }
}


