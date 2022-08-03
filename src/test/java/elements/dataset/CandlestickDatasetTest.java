package elements.dataset;

import elements.dataset.candlestick.Candlestick;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void findCandlestickMinTest() {

    //given
        ArrayList<Candlestick> candles=new ArrayList<>();
        candles.add(new Candlestick("c",1,4,0.5,2));
        candles.add(new Candlestick("c",1,3,0.8,2));
        candles.add(new Candlestick("c",1,7,2.5,2));
        candles.add(new Candlestick("c",1,12,5.5,2));
        candles.add(new Candlestick("c",1,5,-0.5,2));
        candles.add(new Candlestick("c",1,5,0.5,2));
     //when
     CandlestickDataset cds=new CandlestickDataset();
     cds.addAllValues(candles);

     //then
        assertEquals(-0.5,cds.findMin());


    }

    @Test
    void findCandlestickMaxTest() {

        //given
        ArrayList<Candlestick> candles=new ArrayList<>();
        candles.add(new Candlestick("c",1,4,0.5,2));
        candles.add(new Candlestick("c",1,3,0.5,2));
        candles.add(new Candlestick("c",1,7,0.5,2));
        candles.add(new Candlestick("c",1,12,0.5,2));
        candles.add(new Candlestick("c",1,-1,0.5,2));
        candles.add(new Candlestick("c",1,5,0.5,2));
        //when
        CandlestickDataset cds=new CandlestickDataset();
        cds.addAllValues(candles);

        //then
        assertEquals(12,cds.findMax());
    }
}