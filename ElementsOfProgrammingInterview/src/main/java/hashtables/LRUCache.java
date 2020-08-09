package hashtables;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache  {

    LinkedHashMap<String, String > cache = new LinkedHashMap<>();

    public LRUCache(final int capacity){
        cache = new LinkedHashMap<String, String>(  capacity,  1,   true){
            @Override protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };

    }

    public void put(String key, String  val){
        this.cache.put(key, val);
    }

    public String get(String key){
        return cache.get(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("1","1");
        lruCache.put("2","2");
        System.out.println(lruCache.get("2"));
        System.out.println(lruCache.get("2"));
        lruCache.put("3","3");
        System.out.println(lruCache.get("1"));
        lruCache.put("4","4");
        System.out.println(lruCache.get("4"));
        System.out.println(lruCache.get("3"));
        System.out.println(lruCache.get("2"));
        System.out.println(lruCache.get("1"));
    }



}
