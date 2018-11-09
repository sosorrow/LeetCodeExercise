package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenationAllWordsV2 {
    public static void main(String[] args) {
        String[] a = {"foo","bar"};
        for (Integer i: new ConcatenationAllWordsV2().findSubstring("barfoothefoobarman", a)) {
            System.out.print(i + "  ");
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> r = new ArrayList<>();
        if ("".equals(s) || words.length == 0) return r;
        if (s.length() < words.length * words[0].length()) return r;
        int size = words[0].length(), l = words.length, t = size * l, gap = s.length() % t, count = s.length() / t;
        Map<String, Integer> wordsMap = new HashMap<>(), sMap = new HashMap<>();
        for (String w : words) {
            if (w.length() != size) return r;
            wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i <= s.length() - t; i++) {
            boolean compare = true;
            String cs = s.substring(i, i + t), key;
            sMap.clear();
            while (cs.length() > 0) {
                key = cs.substring(0, size);
                sMap.put(key, sMap.getOrDefault(key, 0) + 1);
                cs = cs.substring(size, cs.length());
            }

            for (String k : wordsMap.keySet()) {
                if (!wordsMap.get(k).equals(sMap.get(k))) {
                    compare = false;
                    break;
                }
            }
            if (compare && !r.contains(i)) r.add(i);
        }

        return r;
    }
}
