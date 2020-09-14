import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;


public class Settings  {
    PApplet p;

    int a = 0;
    int x, y;
    boolean updated = false;
    AlmindeligKnap btnUpSize;
    AlmindeligKnap btnDownSize;
    PVector[] resolution = {new PVector(640, 480),new PVector(1080, 768), new PVector(1280, 720),
    new PVector(1920, 1080), new PVector(0, 0)};

    Settings(PApplet p){
        this.p = p;
        btnUpSize = new AlmindeligKnap(p, 0, 0, p.height / 6, p.height / 6, "<");
        btnDownSize = new AlmindeligKnap(p, (p.height / 6) * 4 + (p.height / 6), 0, p.height / 6, p.height / 6, "> ");
    }

    public void DrawSettings(){
        p.clear();
        p.background(200);

      p.textSize(30);
        if(a == resolution.length -1) {
            p.text("screen resolution: \n " + "FullScreen", 10,250);
        }else{
            p.text("screen resolution: \n" + (int) resolution[a].x + "x" + (int) resolution[a].y, 10,250);
        }

        p.textSize(25);

        btnUpSize.tegnKnap();
        btnDownSize.tegnKnap();

        if(btnDownSize.erKlikket()) {
            a--;
            if (a<0)
                a = resolution.length - 1;

            if (a == resolution.length - 1) {
                x = getJFrame(p.getSurface()).getX();
                y = getJFrame(p.getSurface()).getY();
                p.frame.setLocation(0, 0);
                p.frame.setSize(p.displayWidth, p.displayHeight);
            } else {
                p.frame.setLocation(x, y);
                p.frame.setSize((int) resolution[a].x, (int) resolution[a].y);
            }
            btnDownSize.registrerRelease();
        }

        if(btnUpSize.erKlikket()) {
            a++;
            if (a == resolution.length)
                a = 0;

            if (a == resolution.length - 1) {
                x = getJFrame(p.getSurface()).getX();
                y = getJFrame(p.getSurface()).getY();
                p.frame.setLocation(0, 0);
                p.frame.setSize(p.displayWidth, p.displayHeight);
            } else {
                p.frame.setLocation(x, y);
                p.frame.setSize((int) resolution[a].x, (int) resolution[a].y);
            }
            btnUpSize.registrerRelease();
        }
    }

    public static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ( (processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }

    public void mouseClickedSettings() {
       btnUpSize.registrerRelease();
        btnDownSize.registrerRelease();


        btnUpSize.registrerKlik(p.mouseX,p.mouseY);
        btnDownSize.registrerKlik(p.mouseX,p.mouseY);

    }
}
