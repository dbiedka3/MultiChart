package chart;

import abstractions.Chart;
import abstractions.Element;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstractChartBuilder implements Chart {


    protected UnitChartConfig config;
    protected Chart chart;
    protected List<Element> elements = new ArrayList<>();
    protected double width;
    protected double height;
    protected int longestDatasetSize;


    abstract Chart addElement(Element element);

    abstract Chart setWidth(double width);

    abstract Chart setHeight(double height);

    abstract Chart addElements(List<Element> elements);

    abstract Chart build();

    abstract boolean validate();

    abstract void scanElements();


}
