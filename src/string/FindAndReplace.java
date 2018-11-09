package string;

public class FindAndReplace {
    public static void main(String[] args) {
        //          0123456789
        String s = "jjievdtjfb";
        int[] index = {4, 6, 1};
        String[] source = {"md","tjgb","jf"};
        String[] target = {"foe","oov","e"};

        System.out.print(new FindAndReplace().findReplaceString(s, index, source, target));
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if ("".equals(S)) return "";
        if (indexes.length == 0) return S;
        int start = 0, t;
        String newStr = "", ts;

        for (int i=0; i<indexes.length - 1; i++) {
            for (int j=i+1; j<indexes.length; j++) {
                if (indexes[i] > indexes[j]) {
                    t = indexes[j];
                    indexes[j] = indexes[i];
                    indexes[i] = t;

                    ts = sources[j];
                    sources[j] = sources[i];
                    sources[i] = ts;

                    ts = targets[j];
                    targets[j] = targets[i];
                    targets[i] = ts;
                }
            }
        }

        for (int i = 0; i < indexes.length; i++) {
            if (start < indexes[i]) newStr += S.substring(start, indexes[i]);
            start = indexes[i];
            System.out.println(S.substring(indexes[i], indexes[i] + sources[i].length()) + " - " + sources[i]);
            if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) {
                newStr += targets[i];
                start = indexes[i] + sources[i].length();
            }
            System.out.println(newStr);
        }
        if (start < S.length()) newStr += S.substring(start, S.length());

        return newStr;
    }
}
