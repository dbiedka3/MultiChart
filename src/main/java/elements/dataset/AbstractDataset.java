package elements.dataset;

import abstractions.Element;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataset<V> implements Element {


    protected List<V> values = new ArrayList<>();
    protected Group constructedElement;

    public AbstractDataset() {
    }

    public AbstractDataset(List<V> values) {
        addAllValues(values);
    }

    public abstract Group construct();

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

    public Group getConstructedElement() {
        return this.constructedElement;
    }

    public void addValue(V value) {
        this.values.add(value);
    }

    public void addAllValues(List<V> values) {
        this.values.addAll(values);
    }

    public void removeValueById(int index) {
        this.values.remove(index);
    }

    public void removeAll() {
        this.values.clear();
    }


}
