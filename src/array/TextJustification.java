package array;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {};
        int max = 16;
        for (String s : new TextJustification().fullJustify(words, max)) System.out.println(s + "|");
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {

        }
        return r;
    }
}
