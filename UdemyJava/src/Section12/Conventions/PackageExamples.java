package src.Section12.Conventions;

import javafx.scene.Node;
//don't need it, but import java.lang. has most base classes
public class PackageExamples {

    Node node1 = null;
    //less efficient, but needed if using a different kind of Node (can't have two imports of same class name)
    javafx.scene.Node node2 = null;

    //intellij forced had to include fully qualified name
    jdk.nashorn.internal.ir.Node node3 = null;

}
