package other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhoucong
 * @time 2018/6/5
 */
public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU();
        LRULinkedHashMap<String,String> map = lru.new LRULinkedHashMap<>(2);
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.forEach((k,v)-> System.out.println(k));
    }
    public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private int capacity;

        public LRULinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > capacity;
        }
    }
}
