package src.Composition;

/**
 * Created by Z001W4M on 12/9/2016.
 */
public class Monitor {

    private String model;
    private String Manufacturer;
    private int size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.Manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.println("Drawing pixel at " + x + "," + y + " in color " + color );
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
