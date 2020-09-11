import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }
    int a = 0;
    int x, y;
    boolean updated = false;
    AlmindeligKnap btnUpSize;
    AlmindeligKnap btnDownSize;
    ToggleKnap btnFullScreen;
    PVector[] resolution = {new PVector(640, 480),new PVector(1080, 768), new PVector(1280, 720),
            new PVector(1920, 1080), new PVector(0, 0)};

    @Override
    public void settings() {
        //fullScreen();
        size(500,500);
    }

    @Override
    public void setup() {
        btnUpSize = new AlmindeligKnap(this, 0, 0, height / 6, height / 6, "<");
        btnDownSize = new AlmindeligKnap(this, (height / 6) * 4 + (height / 6), 0, height / 6, height / 6, "> ");

    }

    static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ( (processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }

    @Override
    public void draw() {
/*        if (a == resolution.length -1 || a < 0 ) {
            a = 0;
        }*/

        clear();
        background(200);

        textSize(30);
        if(a == resolution.length -1) {
            text("screen resolution: \n " + "FullScreen", 10,250);
        }else{
            text("screen resolution: \n" + (int) resolution[a].x + "x" + (int) resolution[a].y, 10,250);
        }

        textSize(25);

        btnUpSize.tegnKnap();
        btnDownSize.tegnKnap();

        if(btnDownSize.erKlikket()) {
            a--;
            if (a<0)
                a = resolution.length - 1;

            if (a == resolution.length - 1) {
                x = getJFrame(getSurface()).getX();
                y = getJFrame(getSurface()).getY();
                surface.setLocation(0, 0);
                surface.setSize(displayWidth, displayHeight);
            } else {
                surface.setLocation(x, y);
                surface.setSize((int) resolution[a].x, (int) resolution[a].y);
            }
            btnDownSize.registrerRelease();
        }

        if(btnUpSize.erKlikket()) {
            a++;
            if (a == resolution.length)
                a = 0;

            if (a == resolution.length - 1) {
                x = getJFrame(getSurface()).getX();
                y = getJFrame(getSurface()).getY();
                surface.setLocation(0, 0);
                surface.setSize(displayWidth, displayHeight);
            } else {
                surface.setLocation(x, y);
                surface.setSize((int) resolution[a].x, (int) resolution[a].y);
            }
            btnUpSize.registrerRelease();
        }
    }

    @Override
    public void mouseClicked() {
        btnUpSize.registrerRelease();
        btnDownSize.registrerRelease();


        btnUpSize.registrerKlik(mouseX,mouseY);
        btnDownSize.registrerKlik(mouseX,mouseY);

    }
}
