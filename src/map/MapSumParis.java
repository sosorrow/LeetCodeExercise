package map;

import java.util.HashMap;
import java.util.Set;

public class MapSumParis {
    private HashMap<String, Integer> map;

    public static void main(String[] args) {
        MapSumParis map = new MapSumParis();

        System.out.println();
    }

    public MapSumParis() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        this.map.put(key, val);
    }

    public int sum(String prefix) {
        int total = 0;
        Set<String> sets = this.map.keySet();
        for (String key : sets) {
            if (key.startsWith(prefix)) {
                total += this.map.get(key);
            }
        }
        return total;
    }
}
