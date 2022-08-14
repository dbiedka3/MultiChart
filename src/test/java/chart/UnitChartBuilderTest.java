package chart;

import abstractions.Chart;
import elements.dataset.CandlestickDataset;
import elements.dataset.LineDataset;
import elements.dataset.candlestick.Candlestick;
import elements.dataset.linedata.LineData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UnitChartBuilderTest {

    @Test
    void testIfScanElementsGivesExpectedMaxCollectionSizeValues() {
        //given

        CandlestickDataset cds = getCandlestickDataset();

        LineDataset lds = getLineDataset();

        //when
        UnitChartBuilder ucb = new UnitChartBuilder();
        ucb.addElement(cds);

        //then
        assertEquals(6, ucb.getLongestDatasetSize());

        ucb.addElement(lds);

        assertEquals(7, ucb.getLongestDatasetSize());


    }

    @Test
    void testIfBalancingIsCorrectlyPerformedWhenElementSizeSmallerThanMax() {

        //given
        LineDataset lds = getLineDataset();
        UnitChartBuilder ucb = new UnitChartBuilder();
        ucb.addElement(lds);


        //when
        ucb.build();

        //then

        assertEquals(79, ucb.getConfig().getCHART_CELL_WIDTH());
        assertEquals(77, ucb.getConfig().getCANDLESTICK_WIDTH());
        assertEquals(0, ucb.getConfig().getINTERLINE_WIDTH());


    }

    @Test
    void testIfDatasetGlobalMinAndMaxAreCorrectlyPassedToUnitChartBuilderAndUnitChartConfig() {

        //given
        LineDataset lds = getLineDataset();
        CandlestickDataset cds = getCandlestickDataset();
        UnitChartBuilder ucb = new UnitChartBuilder();
        ucb.addElement(lds);
        ucb.addElement(cds);

        //when
        ucb.build();

        //then
        assertEquals(-0.5, ucb.getMinDatasetValue());
        assertEquals(-0.5, ucb.getConfig().getMinDatasetValue());
        assertEquals(12, ucb.getMaxDatasetValue());
        assertEquals(12, ucb.getConfig().getMaxDatasetValue());

    }


    private LineDataset getLineDataset() {
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
        return lds;
    }

    private CandlestickDataset getCandlestickDataset() {
        CandlestickDataset cds = new CandlestickDataset();

        ArrayList<Candlestick> candles = new ArrayList<>();
        candles.add(new Candlestick("c", 1, 4, 0.5, 2));
        candles.add(new Candlestick("c", 1, 3, 0.8, 2));
        candles.add(new Candlestick("c", 1, 7, 2.5, 2));
        candles.add(new Candlestick("c", 1, 12, 5.5, 2));
        candles.add(new Candlestick("c", 1, 5, -0.5, 2));
        candles.add(new Candlestick("c", 1, 5, 0.5, 2));

        cds.addAllValues(candles);
        return cds;
    }


}
