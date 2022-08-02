package elements.dataset.linedata;

import lombok.Getter;

@Getter
public class LineData {

    private String label;
    private double value;

    public LineData(String label, double value) {
        this.label = label;
        this.value = value;
    }
}
