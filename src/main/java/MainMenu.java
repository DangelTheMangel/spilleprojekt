
import processing.core.PApplet;

public class MainMenu {
    PApplet p;
    AlmindeligKnap btnPlay;
    AlmindeligKnap btnSetting;
    AlmindeligKnap btnInfo;
    AlmindeligKnap btnQuit;
    Settings settings;



    public MainMenu(PApplet p, int i) {
        this.p = p;

        btnPlay = new AlmindeligKnap(p,p.width/4,p.height/6,p.width/2, p.height/12,"PLay");
        btnInfo = new AlmindeligKnap(p,p.width/4,p.height/12 + p.height/6 + 10   ,p.width/2, p.height/12,"How to play");
        btnSetting = new AlmindeligKnap(p,p.width/4,2*p.height/12 + p.height/6 + 20,p.width/2, p.height/12,"Settings");
        btnQuit = new AlmindeligKnap(p,p.width/4,3*p.height/12 + p.height/6 + 30,p.width/2, p.height/12,"Quit");
        settings = new Settings(p);
    }



    public void DrawMenu(){


        p.clear();
        p.background(200);

        //p.textAlign(p.CENTER, p.BOTTOM);
        p.textSize(35);
        p.text("Crazy taxi driver!!!!!!", p.width/4 ,p.height/12 );
        p.textSize(25);
        btnPlay.tegnKnap();
        btnInfo.tegnKnap();
        btnSetting.tegnKnap();
        btnQuit.tegnKnap();


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
        if(btnInfo.erKlikket()){
            p.println("I Kid You Not Jeff, He Turns Himself Into a Pickle");
            btnInfo.registrerRelease();

        }


        // settings.DrawSettings();
    }

    public void MouseClickedMenu(){
        //settings.mouseClickedSettings();

        btnPlay.registrerKlik(p.mouseX,p.mouseY);
        btnQuit.registrerKlik(p.mouseX,p.mouseY);
        btnSetting.registrerKlik(p.mouseX,p.mouseY);
        btnInfo.registrerKlik(p.mouseX,p.mouseY);

        if(btnSetting.erKlikket()){
            settings.mouseClickedSettings();

        }

    }
}
