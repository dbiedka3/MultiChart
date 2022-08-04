package config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitChartConfig implements GlobalConstants {

    private static double CHART_CELL_WIDTH;
    private static double CANDLESTICK_WIDTH;
    private static double LEFT_PADDING;
    private static double RIGHT_PADDING;
    private static double TOP_PADDING;
    private static double BOTTOM_PADDING;
    public static double CHART_WIDTH;
    public static double CHART_HEIGHT;

    public UnitChartConfig() {
        init();
    }


    private void init() {
        this.CHART_CELL_WIDTH = MIN_CHART_CELL_WIDTH;
        this.CANDLESTICK_WIDTH = MIN_CANDLESTICK_WIDTH;
        this.LEFT_PADDING = MIN_LEFT_PADDING;
        this.RIGHT_PADDING = MIN_RIGHT_PADDING;
        this.TOP_PADDING = MIN_TOP_PADDING;
        this.BOTTOM_PADDING = MIN_BOTTOM_PADDING;
        this.CHART_WIDTH = MIN_CHART_WIDTH;
        this.CHART_HEIGHT = MIN_CHART_HEIGHT;


    }


}
