package chart;

import abstractions.Chart;
import abstractions.Element;
import javafx.scene.Group;

import java.util.List;

public class UnitChartBuilder extends AbstractChartBuilder {


    private UnitChart chart;

    public UnitChartBuilder() {
    }

    @Override
    public Chart addElement(Element element) {
        this.elements.add(element);
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
        return this;
    }

    @Override
    public Chart build() {

        buildUnitChart();
        return this.chart;
    }


    private void buildUnitChart() {

        Group group = new Group();
        for (Element e : this.elements) {
            group.getChildren().add(e.getConstructedElement());

        }
        this.chart=new UnitChart(group);

    }
}
