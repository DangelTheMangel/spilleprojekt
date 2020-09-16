
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

            btnPlay = new ToggleKnap(p, p.width / 4, p.height / 6, p.width / 2, p.height / 12, "PLay");
            btnInfo = new AlmindeligKnap(p, p.width / 4, p.height / 12 + p.height / 6 + 10, p.width / 2, p.height / 12, "How to play");
            btnSetting = new AlmindeligKnap(p, p.width / 4, 2 * p.height / 12 + p.height / 6 + 20, p.width / 2, p.height / 12, "Settings");
            btnQuit = new AlmindeligKnap(p, p.width / 4, 3 * p.height / 12 + p.height / 6 + 30, p.width / 2, p.height / 12, "Quit");
            settings = new Settings(p);
        exitInfo = new AlmindeligKnap(p, p.width/2, p.height - p.height/12, p.width/2, p.height/12,"Back");

    }



    public void DrawMenu(PImage baground,PImage info){


                p.clear();
                p.imageMode(p.CENTER);
                p.image(baground, p.width / 2, p.height / 2, p.width, p.height);

                //p.textAlign(p.CENTER, p.BOTTOM);
                p.textSize(35);
                p.text("Crazy taxi driver!!!!!!", p.width / 4, p.height / 12);
                p.textSize(25);
                if(menuTrue) {
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
            settings.DrawSettings();
            if(settings.exitSettingse.erKlikket()){
                settings.exitSettingse.registrerRelease();
                btnSetting.registrerRelease();

            }

        }
        p.println(menuTrue);
        if(btnInfo.erKlikket()){
            menuTrue = false;
            infoMenu = true;
            p.image(info,250,250);
            btnInfo.registrerRelease();

        }
        if(infoMenu) {
            p.image(info, p.width/2, p.height/2, 677,376);
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

        btnPlay.registrerKlik(p.mouseX,p.mouseY);
        btnQuit.registrerKlik(p.mouseX,p.mouseY);
        btnSetting.registrerKlik(p.mouseX,p.mouseY);
        btnInfo.registrerKlik(p.mouseX,p.mouseY);
        exitInfo.registrerKlik(p.mouseX,p.mouseY);
        if(btnSetting.erKlikket()){
            settings.mouseClickedSettings();

        }

    }
}
