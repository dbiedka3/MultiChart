package abstractions;

import chart.UnitChartConfig;
import javafx.scene.Group;

public interface Element {

    Group getConstructedElement();
    void construct(UnitChartConfig unitChartConfig);

}
