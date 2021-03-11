package LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: 99615
 * @Date: 2021/1/29 15:12
 * @Description:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_SIZE = 10;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_SIZE;
    }

    LRUCache() {
        super(MAX_SIZE, 0.75f, true);
    }
}
