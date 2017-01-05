package src.Interfaces;

import java.util.List;

/**
 * Created by Z001W4M on 1/4/2017.
 */
public interface IDataStore {

    void storeValues(List<String> values);

    List<String> returnValues();

}


