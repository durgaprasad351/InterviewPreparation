import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146_LRU_Cache {

    int capacity;

    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    LinkedList<Integer> lru = new LinkedList<Integer>();

    public _146_LRU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = cache.getOrDefault(key, -1);
        if(val != -1){
            promoteKey(key);
        }
        return val;
    }

    private void promoteKey(int key) {
        int index = lru.indexOf(Integer.valueOf(key));
        if(index >0) {
            lru.remove(index);
            lru.addFirst(key);
        }
    }

    public void put(int key, int value) {
        Integer val = cache.put(key,value);
        if(null != val) {
            if (lru.size() >= capacity) {
                int keyToEvict = lru.removeLast();
                cache.remove(keyToEvict);
            }
            lru.addFirst(key);
        }else{
            promoteKey(key);
        }
    }



    public static void main(String[] args) {
        _146_LRU_Cache cache = new _146_LRU_Cache(2);
        //["LRUCache","get","put","get","put","put","get","get"]
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]


        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println();
    }
}
