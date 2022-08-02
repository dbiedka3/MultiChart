package chart;

import abstractions.Chart;
import javafx.scene.Group;
import lombok.Getter;

@Getter
public class UnitChart implements Chart{


    private Group chart;

    public UnitChart(Group chart) {
        this.chart = chart;
    }
}
