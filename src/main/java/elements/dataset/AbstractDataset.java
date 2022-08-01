package elements.dataset;

import abstractions.Element;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDataset<K, V> implements Element {

    protected Map<K,V> map=new HashMap<K, V>();



}
