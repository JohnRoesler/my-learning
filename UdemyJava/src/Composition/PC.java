package src.Composition;

/**
 * Created by Z001W4M on 12/11/2016.
 */
public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        //Draw fancy graphics with logo
        monitor.drawPixelAt(1250,1000,"yellow");
    }

}
