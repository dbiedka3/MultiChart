package elements.dataset;

import elements.dataset.linedata.LineData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineDatasetTest {



    @Test
    void findMaxTest() {
    //given
    LineDataset lds=new LineDataset();

        ArrayList<LineData> ld=new ArrayList<>();
        ld.add(new LineData("1",1));
        ld.add(new LineData("1",2));
        ld.add(new LineData("1",3));
        ld.add(new LineData("1",4));
        ld.add(new LineData("1",6));
        ld.add(new LineData("1",6.3));
        ld.add(new LineData("1",6.7));

        //when
        lds.addAllValues(ld);

        //then
        assertEquals(6.7,lds.findMax());
        assertEquals(lds.getMaxValue(),lds.findMax());

        lds.addValue(new LineData("2",12));

        assertEquals(12,lds.findMax());
        assertEquals(lds.getMaxValue(),lds.findMax());

    }

    @Test
    void findMinTest() {
        //given
        LineDataset lds=new LineDataset();

        ArrayList<LineData> ld=new ArrayList<>();
        ld.add(new LineData("1",-2));
        ld.add(new LineData("1",2));
        ld.add(new LineData("1",3));
        ld.add(new LineData("1",4));
        ld.add(new LineData("1",6));
        ld.add(new LineData("1",6.3));
        ld.add(new LineData("1",6.7));

        //when
        lds.addAllValues(ld);

        //then
        assertEquals(-2,lds.findMin());
        assertEquals(lds.getMinValue(),lds.findMin());

        lds.addValue(new LineData("2",-12));

        assertEquals(-12,lds.findMin());
        assertEquals(lds.getMinValue(),lds.findMin());

    }
}