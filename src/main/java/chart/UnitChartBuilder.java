package chart;

import abstractions.Chart;
import abstractions.Element;
import elements.dataset.AbstractDataset;
import javafx.scene.Group;
import lombok.Getter;

import java.util.List;

@Getter
public class UnitChartBuilder extends AbstractChartBuilder {


    private UnitChart chart;

    public UnitChartBuilder() {
    }

    @Override
    public Chart addElement(Element element) {
        this.elements.add(element);
        scanElements();
        return this;
    }

    @Override
    public Chart setWidth(double width) {
        this.width = width;
        return this;
    }

    @Override
    public Chart setHeight(double height) {
        this.height = height;
        return this;
    }

    @Override
    public Chart addElements(List<Element> elements) {
        this.elements.addAll(elements);
        scanElements();
        return this;
    }

    @Override
    public Chart build() {

        buildUnitChart();
        return this.chart;
    }

    /**
     * Validates if minimum requirements are met
     * to construct unit chart
     */

    @Override
    boolean validate() {
        return false;
    }

    /**
     * Scans Element list and finds
     * maximum size of Dataset-type element
     * to be later used in chart balancing
     * process
     */

    @Override
    public void scanElements() {
        this.elements.forEach(e -> {
            if (e instanceof AbstractDataset) {
                if (this.longestDatasetSize < ((AbstractDataset<?>) e).getValues().size())
                    this.longestDatasetSize = ((AbstractDataset<?>) e).getValues().size();
            }

        });
    }


    private void buildUnitChart() {

        initializeUnitChartConfig();

        Group group = new Group();
        for (Element e : this.elements) {

            e.construct(config);

            group.getChildren().add(e.getConstructedElement());

        }
        this.chart = new UnitChart(group);

    }

    private void initializeUnitChartConfig() {

        this.config = new UnitChartConfig();
        config.setNewChartWidth(this.width);
        config.setNewChartHeight(this.height);
        balanceChart();


    }

    private void balanceChart() {

        double plottingAreaWidth = this.config.getCHART_WIDTH() - this.config.getLEFT_PADDING() - this.config.getRIGHT_PADDING();

        double tempCellWidth = this.config.getCHART_CELL_WIDTH();
        double tempCandlestickWidth = this.config.getCANDLESTICK_WIDTH();

        while (this.longestDatasetSize * (tempCellWidth + 2d) < plottingAreaWidth) {
            tempCellWidth += 2d;
            tempCandlestickWidth += 2d;
        }

        double tempInterlineWidth = this.config.getINTERLINE_WIDTH();

        while (this.longestDatasetSize * tempCellWidth + this.longestDatasetSize * (tempCandlestickWidth + 1d) < plottingAreaWidth) {
            tempInterlineWidth++;

        }

        /*Set config with new for cell, candlestick and interline values*/
        this.config.setCHART_CELL_WIDTH(tempCellWidth);
        this.config.setCANDLESTICK_WIDTH(tempCandlestickWidth);
        this.config.setINTERLINE_WIDTH(tempInterlineWidth);
    }


}
