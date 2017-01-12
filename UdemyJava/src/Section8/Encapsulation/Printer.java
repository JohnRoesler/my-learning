package src.Section8.Encapsulation;

/**
 * Created by Z001W4M on 12/13/2016.
 */
public class Printer {
    private int tonerLevel; //between 0-100
    private int numSheetsofPaperUsed;
    private boolean duplex;
    private int pagesPerTonerPercent;

    public Printer(boolean duplex) {
        this.tonerLevel = 100;
        this.numSheetsofPaperUsed = 0;
        this.duplex = duplex;
        this.pagesPerTonerPercent = 1;
    }

    public void fillToner(int fillLevel){
        if (fillLevel > 100 || fillLevel < 0){
            System.out.println("The printer must be filled between 0-100 not more or less");
        }else {
            this.tonerLevel = fillLevel;
            System.out.println("The printer is now filled to " + fillLevel);
        }
    }

    public void print(String document, int pages, boolean doubleSided){
        if (doubleSided && !this.duplex){
            System.out.println("This printer cannot print double sided documents!");
            return;
        }
        if (pages > (tonerLevel / pagesPerTonerPercent)){
            System.out.println("This printer needs more toner!");
            return;
        }
        tonerLevel -= (pages/pagesPerTonerPercent);
        if (doubleSided){
            numSheetsofPaperUsed += Math.ceil(pages/2f);
        }else{
            numSheetsofPaperUsed += pages;
        }
        System.out.println("You successfully printed a " + pages + " document.\n" +
                "This printer has printed " + numSheetsofPaperUsed + " sheets of paper.\n" +
                "The toner level is " + tonerLevel);
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumSheetsofPaperUsed() {
        return numSheetsofPaperUsed;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
