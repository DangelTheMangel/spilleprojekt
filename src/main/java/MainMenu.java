
import processing.core.PApplet;
import processing.core.PImage;

public class MainMenu {
    PApplet p;
    ToggleKnap btnPlay;
    AlmindeligKnap btnSetting;
    AlmindeligKnap btnInfo;
    AlmindeligKnap btnQuit;
    Settings settings;
    AlmindeligKnap exitInfo;


    boolean menuTrue = true;
    boolean infoMenu = false;

    public MainMenu(PApplet p, int i ) {
        this.p = p;

            btnPlay = new ToggleKnap(p, p.width / 4, (int) (p.height / 12 + p.height / 6 + (((p.width/13) * 1))), p.width / 2, p.height / 12, "Play");
            btnInfo = new AlmindeligKnap(p, p.width / 4, (int) (p.height / 12 + p.height / 6 + (((p.width/13) * 2))), p.width / 2, p.height / 12, "How to play");
            btnSetting = new AlmindeligKnap(p, p.width / 4, (int) (p.height / 12 + p.height / 6 + (((p.width/13) * 3))), p.width / 2, p.height / 12, "Settings");
            btnQuit = new AlmindeligKnap(p, p.width / 4, (int) (p.height / 12 + p.height / 6 + (((p.width/13) * 4))), p.width / 2, p.height / 12, "Quit");
            settings = new Settings(p);
        exitInfo = new AlmindeligKnap(p, p.width/4, p.height - p.height/12, p.width/2, p.height/12,"Back");

    }



    public void DrawMenu(PImage baground,PImage info){


            p.clear();
            p.imageMode(p.CENTER);
            p.image(baground, p.width / 2, p.height / 2, p.width, p.height);

            //p.textAlign(p.CENTER, p.BOTTOM);

            if(menuTrue) {
                p.textAlign(p.CENTER);
                p.textSize((float) (p.width/16.55));
                p.fill(10);
                p.text("Royal Rally", p.width / 2 + (float) (p.width/96), (float) (p.width/16.55)  + p.height/12);
                p.fill(200);
                p.text("Royal Rally", p.width / 2, (float) (p.width/16.55) + p.height/12);
                p.textSize(p.width/48);
                p.textAlign(p.CORNER);
                btnPlay.tegnKnap();
                btnInfo.tegnKnap();
                btnSetting.tegnKnap();
                btnQuit.tegnKnap();
            }


        if(btnQuit.erKlikket()){
            p.exit();
            btnQuit.registrerRelease();
        }
        if(btnSetting.erKlikket()){
            menuTrue = false;
            settings.DrawSettings();
            if(settings.exitSettingse.erKlikket()){
                menuTrue = true;
                RestMenuKnap(btnPlay, 1);
                RestMenuKnap(btnInfo, 2);
                RestMenuKnap(btnSetting,3);
                RestMenuKnap(btnQuit,4);
                settings.exitSettingse.registrerRelease();
                btnSetting.registrerRelease();


            }

            if(settings.btnonePlayer.erKlikket()){
               settings.players =false;

                settings.btnonePlayer.registrerRelease();
            }
            if (settings.btntwoPlayers.erKlikket()){

                settings.players = true;
                settings.btntwoPlayers.registrerRelease();
            }


        }

        if(btnInfo.erKlikket()){
            menuTrue = false;
            infoMenu = true;
            p.image(info,250,250);
            btnInfo.registrerRelease();

        }
        if(infoMenu) {
            p.imageMode(p.CORNER);
            p.fill(200);
            p.rect(p.width/12, p.height - p.height/3 - p.height/6, p.width -(p.width/12)*2 ,p.height - (p.height/2 + p.height/8));
            p.fill(0);
            p.image(info, 0 + (p.width/2)/2, p.width/96, p.width/2,p.height/2);
            p.textSize(p.width/60);
            p.textAlign(p.CORNER);

            p.text(" Rules:\n" +
                    " be the last on the field to win. pick up power-ups to get one\n" +
                    " advantage over the others. when you push others they\n" +
                    " become faster and you become slower.",p.width/12, p.height - p.height/3 - p.height/12 );
            p.textMode(p.CORNER);
            exitInfo.tegnKnap();
            if(exitInfo.erKlikket()){
                menuTrue = true;
                infoMenu = false;
                exitInfo.registrerRelease();
            }
        }
        // settings.DrawSettings();
    }

    public void MouseClickedMenu(){
        //settings.mouseClickedSettings();
        if(menuTrue) {
            btnPlay.registrerKlik(p.mouseX, p.mouseY);
            btnQuit.registrerKlik(p.mouseX, p.mouseY);
            btnSetting.registrerKlik(p.mouseX, p.mouseY);
        }
        btnInfo.registrerKlik(p.mouseX,p.mouseY);
        exitInfo.registrerKlik(p.mouseX,p.mouseY);
        if(btnSetting.erKlikket()){
            settings.mouseClickedSettings();

        }


    }

    void RestMenuKnap(Knap knap, int knapnummer){
        Restknap(knap,p.width/4,(int) (p.height / 12 + p.height / 6 + (((p.width/13) * knapnummer))),p.width/2,p.height/12);
    }

    void Restknap(Knap knap, int posX,int poxY,int sizeX,int sizeY){
        knap.positionX = posX;
        knap.positionY = poxY;
        knap.sizeX = sizeX;
        knap.sizeY = sizeY;

    }
}
