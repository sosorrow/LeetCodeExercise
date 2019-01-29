package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"What","must","be","acknowledgment","shall","be"};
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int max = 16;
        for (String s : new TextJustification().fullJustify(words, max)) System.out.println(s + "|");
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<>();
        if (words.length == 0) return r;
        int l = words.length, total = 0, start = 0, b, a;
        String w = "";
        for (int i = 0; i < l; i++) {
            total += words[i].length();
            if (total > maxWidth) {
                if (i - start > 1) {
                    total -= words[i].length() + 1;
                    b = (maxWidth - total) / (i - start - 1);
                    a = (maxWidth - total) % (i - start - 1);
                    for (int j = start; j < i - 1; j++) {
                        w += words[j] + " ";
                        for (int k = 0; k < b; k++) w += " ";
                        if (j - start < a) w += " ";
                    }
                    w += words[i - 1];
                    r.add(w);
                } else {
                    total -= words[i].length() + 1;
                    b = maxWidth - total;
                    w += words[start];
                    for (int k = 0; k < b; k++) w += " ";
                    r.add(w);
                }
                w = "";
                total = words[i].length() + 1;
                start = i;
            } else total++;
        }
        for (; start < l; start++) {
            w += words[start] + " ";
        }
        total = w.length();
        if (total > maxWidth) {
            r.add(w.substring(0, maxWidth));
        } else {
            for (int k = 0; k < maxWidth - total; k++) {
                w += " ";
            }
            r.add(w);
        }
        return r;
    }
}
