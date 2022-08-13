package elements.dataset;

import abstractions.Element;
import chart.UnitChartConfig;
import javafx.scene.Group;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstractDataset<V> implements Element {


    protected List<V> values = new ArrayList<>();
    protected Group constructedElement;
    protected double minValue;
    protected double maxValue;

    public AbstractDataset() {

    }

    public AbstractDataset(List<V> values) {
        addAllValues(values);
        updateMinAndMax();
    }

    public abstract Group construct(UnitChartConfig config);

    public abstract double findMin();

    public abstract double findMax();

    protected double normalize(double v, double min, double max) {

        try {
            return (v - min) / (max - min);
        } catch (ArithmeticException e) {
            return 0d;
        }

    }

    public List<V> getValues() {
        return this.values;
    }

    public double getMinValue() {
        return this.minValue;
    }

    public double getMaxValue() {
        return this.maxValue;
    }

    public Group getConstructedElement() {
        return this.constructedElement;
    }

    public void addValue(V value) {
        this.values.add(value);
        updateMinAndMax();
    }

    public void addAllValues(List<V> values) {
        this.values.addAll(values);
        updateMinAndMax();
    }


    public void updateMinAndMax() {
        this.minValue = findMin();
        this.maxValue = findMax();
    }


}
