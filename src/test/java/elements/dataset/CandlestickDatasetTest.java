package elements.dataset;

import elements.dataset.candlestick.Candlestick;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class CandlestickDatasetTest {

    @Test
    public void checkIfInstanceIsCreatedCorrectly() {

        Candlestick c1=new Candlestick("l1",10,20,30,40);
        Candlestick c2=new Candlestick("l2",15,25,35,45);

        CandlestickDataset cd1=new CandlestickDataset();
        cd1.addValue(c1);
        cd1.addValue(c2);

        ArrayList<Candlestick> list=new ArrayList<>();
        list.add(c1);
        list.add(c2);
        CandlestickDataset cd2=new CandlestickDataset(list);

    }
}