package elements.dataset.candlestick;


import lombok.Getter;

@Getter
public class Candlestick {

    String label;
    double o, h, l, c;

    public Candlestick(String label, double o, double h, double l, double c) {
        this.label = label;
        this.o = o;
        this.h = h;
        this.l = l;
        this.c = c;
    }

}
