package phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        for (String word : new LetterCombinationsOfPhoneNumber().letterCombinations(digits)) {
            System.out.println(word);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if ("".equals(digits)) return result;

        String[][] arrs = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };

        String[] r = {}, temp, next;
        int i = 0;
        for (char c : digits.toCharArray()) {
            next = arrs[c - '2'];
            if (r.length == 0) r = next;
            else {
                i = 0;
                temp = new String[r.length * next.length];
                for (String m: r) {
                    for (String n : next) {
                        temp[i] = m.concat(n);
                        i++;
                    }
                }
                r = temp;
            }
        }
        result = Arrays.asList(r);
        return result;
    }
}
