package mutation;

public class GeneticMutation {
    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(new GeneticMutation().minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        if ("".equals(start) || "".equals(end) || bank.length == 0) return -1;
        if (start.equals(end)) return 0;

        int count = Integer.MAX_VALUE;
        for (int i=0; i<bank.length; i++) {
            if (oneDiff(start, bank[i])) {
                if (bank.length == 1) return 1;
                System.out.println("one diff:" + bank[i] + "  -  " + start);
                String[] s = splice(i, bank);
                int c = minMutation(bank[i], end, s);
                if (c != -1) count = Math.min(c + 1, count);
            }
            System.out.println();
        }

        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public String[] splice(int index, String[] arr){
        String[] s = new String[arr.length - 1];
        for (int i=0; i < arr.length; i++) {
            if (i < index) s[i] = arr[i];
            else if (i > index) s[i - 1] = arr[i];
        }
        return s;
    }

    public boolean oneDiff(String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count >= 1) return false;
                else count++;
            }
        }
        return true;
    }
}
