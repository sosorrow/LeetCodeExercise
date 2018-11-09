public class NextGreaterElement {
    public static void main(String[] args){
        System.out.println(new NextGreaterElement().nextGreaterElement(230241));
    }

    public int nextGreaterElement(int n) {
        if (n <= 10) return -1;
        char[] chrs = String.valueOf(n).toCharArray();
        int l = chrs.length;
        for (int i = l - 2; i >= 0; i--) {
            for (int j = l - 1; j > i; j--) {
                if (chrs[i] < chrs[j]) {
                    char temp = chrs[i];
                    chrs[i] = chrs[j];
                    chrs[j] = temp;

                    for (int m = i + 1; m < l - 1; m++) {
                        for (int N = m + 1; N < l; N++) {
                            if (chrs[m] > chrs[N]) {
                                temp = chrs[m];
                                chrs[m] = chrs[N];
                                chrs[N] = temp;
                            }
                        }
                    }

                    double d = Double.parseDouble(String.valueOf(chrs));
                    return d > (double)Integer.MAX_VALUE ? -1 : (int)d;
                }
            }
        }
        return -1;
    }
}
