import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;


public class Settings  {
    PApplet p;

    int a = 0;
    int x, y;
    int posX,posY, smallBtn, bigBtnX,BigBtnY;
    float Overskrift , broedtext ;
    boolean updated = false;
  public boolean players = false;
    AlmindeligKnap btnUpSize;
    AlmindeligKnap btnDownSize;
    AlmindeligKnap exitSettingse;

    AlmindeligKnap btntwoPlayers;
    AlmindeligKnap btnonePlayer;

    PVector[] resolution = {new PVector(640, 480),new PVector(1080, 768), new PVector(1280, 720),
    new PVector(1920, 1080), new PVector(0, 0)};

    Settings(PApplet p){
        this.p = p;
        smallBtn = p.height/6;
        btnUpSize = new AlmindeligKnap(p, p.width/12, p.width/12, smallBtn, smallBtn, "<");
        btnDownSize = new AlmindeligKnap(p, p.width - (p.width/12 + smallBtn), p.width/12, smallBtn, smallBtn, "> ");


        exitSettingse = new AlmindeligKnap(p, p.width/4, (int) (p.height / 12 + p.height / 6 + (((p.width/13) * 6))), p.width/2, p.height/12,"Back");

        btntwoPlayers = new AlmindeligKnap(p, p.width/12, p.height - p.height/2, smallBtn, smallBtn,"+");
        btnonePlayer = new AlmindeligKnap(p, p.width - (p.width/12 + smallBtn), p.height - p.height/2, smallBtn, smallBtn,"-");

        Overskrift = p.width/24;
        broedtext = p.width/48;
    }

    public void DrawSettings(){
        Overskrift = (float) ((p.width/48) * 1.5);
        broedtext = p.width/48;
        p.clear();
        p.background(200);


        p.textSize(Overskrift);
        p.textAlign(p.CENTER, p.TOP);
        p.text("Resolution: ", p.width/2,0);
        p.text("Gamemode: ", p.width/2, (p.height - p.width/20) - p.height/2);

        p.textSize(broedtext);






        if(a == resolution.length -1) {
            p.text("screen resolution: \n " + "FullScreen", p.width/2, p.width/12);
        }else{
            p.text("screen resolution: \n" + (int) resolution[a].x + "x" + (int) resolution[a].y, p.width/2, p.width/12);
        }

        if(players) {
            p.text("Multiplayer", p.width/2, p.height - p.height/2);
        }else{
            p.text("Singleplayer", p.width/2, p.height - p.height/2);
        }

        p.textAlign(p.CORNER, p.CORNER);
        btnUpSize.tegnKnap();
        btnDownSize.tegnKnap();
        exitSettingse.tegnKnap();
        btnonePlayer.tegnKnap();
        btntwoPlayers.tegnKnap();
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
    boolean multiplePlayers(){
        return players;
    }
    public static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ( (processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }

    public void mouseClickedSettings() {
       btnUpSize.registrerRelease();
        btnDownSize.registrerRelease();
        btnonePlayer.registrerKlik(p.mouseX,p.mouseY);
        btntwoPlayers.registrerKlik(p.mouseX,p.mouseY);

        btnUpSize.registrerKlik(p.mouseX,p.mouseY);
        btnDownSize.registrerKlik(p.mouseX,p.mouseY);

        exitSettingse.registrerKlik(p.mouseX,p.mouseY);

    }
    void Restknap(Knap knap, int posX,int poxY,int sizeX,int sizeY){
        knap.positionX = posX;
        knap.positionY = poxY;
        knap.sizeX = sizeX;
        knap.sizeY = sizeY;

    }
}

