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
    void scanElements() {
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


    }
}
