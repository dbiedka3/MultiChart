package elements.dataset;


import elements.dataset.candlestick.Candlestick;
import elements.dataset.linedata.LineData;
import javafx.scene.Group;

import java.util.List;
import java.util.Optional;

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

//    public double findMaxStream() {
//
//        Optional<LineData> max = this.getValues().stream().max((o1, o2) -> {
//
//                    if (o1.getValue() > o2.getValue()) return 1;
//                    else if (o1.getValue() < o2.getValue()) return -1;
//                    else return 0;
//                }
//        );
//        return max.get().getValue();
//    }
}

