package abstractions;

import config.UnitChartConfig;
import javafx.scene.Group;

public interface Element {

    Group getConstructedElement();
    Group construct(UnitChartConfig unitChartConfig);

}
