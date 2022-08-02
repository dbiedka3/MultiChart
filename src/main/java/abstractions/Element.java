package abstractions;

import javafx.scene.Group;

public interface Element {

    Group getConstructedElement();
    Group construct();

}
