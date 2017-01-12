package src.Section10.Interfaces;

import java.util.List;

/**
 * Created by Z001W4M on 1/5/2017.
 */
public interface ISaveable {

    List<String> write();
    void read(List<String > savedValues);

}
