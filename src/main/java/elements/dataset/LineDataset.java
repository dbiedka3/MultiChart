package elements.dataset;


import elements.dataset.linedata.LineData;
import javafx.scene.Group;

import java.util.List;

public class LineDataset extends AbstractDataset<LineData> {

    public LineDataset() {
    }

    public LineDataset(List<LineData> values) {
        super(values);
    }

    @Override
    public Group construct() {
        return null;
    }

}
