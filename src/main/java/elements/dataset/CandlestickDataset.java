package elements.dataset;

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
    public Group construct() {
        return null;
    }

}
