package chart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitChartConfigTest {

    @Test
    void testIfSetNewChartWidthAdjustsChartWidthCorrectly() {

        //given
        UnitChartConfig unitChartConfig = new UnitChartConfig();

        //when
        unitChartConfig.setNewChartWidth(722);

        //then
        assertEquals(725, unitChartConfig.getCHART_WIDTH());

    }
}