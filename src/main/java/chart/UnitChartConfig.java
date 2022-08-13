package chart;

import config.GlobalConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitChartConfig implements GlobalConstants {

    private double CHART_CELL_WIDTH;
    private double CANDLESTICK_WIDTH;
    private double INTERLINE_WIDTH;
    private double LEFT_PADDING;
    private double RIGHT_PADDING;
    private double TOP_PADDING;
    private double BOTTOM_PADDING;
    public double CHART_WIDTH;
    public double CHART_HEIGHT;

    public UnitChartConfig() {
        init();
    }


    private void init() {
        this.CHART_CELL_WIDTH = MIN_CHART_CELL_WIDTH;
        this.CANDLESTICK_WIDTH = MIN_CANDLESTICK_WIDTH;
        this.INTERLINE_WIDTH=MIN_INTERLINE_WIDTH;
        this.LEFT_PADDING = MIN_LEFT_PADDING;
        this.RIGHT_PADDING = MIN_RIGHT_PADDING;
        this.TOP_PADDING = MIN_TOP_PADDING;
        this.BOTTOM_PADDING = MIN_BOTTOM_PADDING;
        this.CHART_WIDTH = MIN_CHART_WIDTH;
        this.CHART_HEIGHT = MIN_CHART_HEIGHT;


    }

    public void setNewChartWidth(double newWidth) {
        if (newWidth > MIN_CHART_WIDTH) {
            setCHART_WIDTH(newWidth);
            completeToDividableByMinCellWith();
        }

    }

    public void setNewChartHeight(double newHeight) {
        if (newHeight > MIN_CHART_HEIGHT) setCHART_HEIGHT(newHeight);
    }

    private void completeToDividableByMinCellWith() {

        int remainder = (int) (this.CHART_WIDTH % MIN_CHART_CELL_WIDTH);
        double complement = MIN_CHART_CELL_WIDTH - (double) remainder;
        setCHART_WIDTH(this.getCHART_WIDTH() + complement);

    }

}
