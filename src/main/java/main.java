import processing.core.PApplet;

public class main extends PApplet {
    public static void main(String[] args) { PApplet.main("main"); }

    ToggleKnap btnSize;

    @Override
    public void settings() {

        size(500,500);

    }

    @Override
    public void setup() {
        btnSize = new ToggleKnap(this,10 + (height/6),0,height/6,height/6,"FullScreen/window" );
    }

    @Override


    public void draw() {
        btnSize.tegnKnap();
        if(btnSize.erKlikket()){
            println("omg!!!!!!!!!");

        }

    }

    @Override
    public void mousePressed() {
        btnSize.registrerKlik(mouseX,mouseY);
        frame.setSize((int)random(100,500),(int)random(100,500));

    }
}
