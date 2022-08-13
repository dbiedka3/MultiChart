package elements.dataset;

import chart.UnitChartConfig;
import elements.dataset.candlestick.Candlestick;
import javafx.scene.Group;

import java.util.List;

public class CandlestickDataset extends AbstractDataset<Candlestick> {

    public CandlestickDataset() {
    }

    public CandlestickDataset(List<Candlestick> values) {
        super(values);
    }

    @Override
    public void construct(UnitChartConfig config) {
        this.constructedElement = new Group();
    }


    @Override
    public double findMin() {
        double min = this.getValues().get(0).getL();
        for (Candlestick c : this.values) {
            if (c.getL() < min) min = c.getL();
        }
        return min;

    }

    @Override
    public double findMax() {
        double max = this.getValues().get(0).getH();
        for (Candlestick c : this.values) {
            if (c.getH() > max) max = c.getH();
        }
        return max;
    }


}
