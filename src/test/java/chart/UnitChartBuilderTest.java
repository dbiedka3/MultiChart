package chart;

import elements.dataset.CandlestickDataset;
import elements.dataset.LineDataset;
import elements.dataset.candlestick.Candlestick;
import elements.dataset.linedata.LineData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UnitChartBuilderTest {

    @Test
    void testIfScanElementsGivesExpectedMaxCollectionSizeValues() {
        //given

        CandlestickDataset cds = new CandlestickDataset();

        ArrayList<Candlestick> candles = new ArrayList<>();
        candles.add(new Candlestick("c", 1, 4, 0.5, 2));
        candles.add(new Candlestick("c", 1, 3, 0.8, 2));
        candles.add(new Candlestick("c", 1, 7, 2.5, 2));
        candles.add(new Candlestick("c", 1, 12, 5.5, 2));
        candles.add(new Candlestick("c", 1, 5, -0.5, 2));
        candles.add(new Candlestick("c", 1, 5, 0.5, 2));

        cds.addAllValues(candles);

        LineDataset lds = new LineDataset();

        ArrayList<LineData> ld = new ArrayList<>();
        ld.add(new LineData("1", 1));
        ld.add(new LineData("1", 2));
        ld.add(new LineData("1", 3));
        ld.add(new LineData("1", 4));
        ld.add(new LineData("1", 6));
        ld.add(new LineData("1", 6.3));
        ld.add(new LineData("1", 6.7));

        lds.addAllValues(ld);

        //when
        UnitChartBuilder ucb = new UnitChartBuilder();
        ucb.addElement(cds);

        //then
        assertEquals(6, ucb.getLongestDatasetSize());

        ucb.addElement(lds);

        assertEquals(7, ucb.getLongestDatasetSize());


    }
}