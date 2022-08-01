package abstractions;

import global.GlobalSettings;

public interface Chart extends GlobalSettings {

    Chart addElement(Element element);

    Chart setWidth(double width);

    Chart setHeight(double height);

    Chart addElements(Element[] elements);

    Chart build();

}
