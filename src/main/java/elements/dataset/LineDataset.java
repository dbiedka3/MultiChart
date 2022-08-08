package elements.dataset;


import chart.UnitChartConfig;
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
    public Group construct(UnitChartConfig config) {
        return null;
    }

    @Override
    public double findMin() {
        double min = this.values.get(0).getValue();
        for (LineData l : this.getValues()) {
            if (l.getValue() < min) min = l.getValue();

        }
        return min;

    }

    @Override
    public double findMax() {

        double max = this.values.get(0).getValue();
        for (LineData l : this.getValues()) {
            if (l.getValue() > max) max = l.getValue();

        }
        return max;
    }


}

