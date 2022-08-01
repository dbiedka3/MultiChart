package chart;

import abstractions.Chart;

import javax.lang.model.util.Elements;

public abstract class AbstractChart implements Chart {


    protected Chart chart;
    protected Elements[] elements;
    protected double width;
    protected double height;


}
