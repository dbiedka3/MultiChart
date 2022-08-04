package chart;

import abstractions.Chart;
import abstractions.Element;
import config.UnitChartConfig;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChartBuilder implements Chart {


    protected UnitChartConfig config;
    protected Chart chart;
    protected List<Element> elements = new ArrayList<>();
    protected double width;
    protected double height;


    abstract Chart addElement(Element element);

    abstract Chart setWidth(double width);

    abstract Chart setHeight(double height);

    abstract Chart addElements(List<Element> elements);

    abstract Chart build();


}
