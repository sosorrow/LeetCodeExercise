import java.util.*;

public class ThreeSumEqualsZero {
    public static void main(String args[]) {
        List<List<Integer>> result = new ThreeSumEqualsZero().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        for (List<Integer> a : result) {
            System.out.println();
            for (int aa : a) {
                System.out.print(aa + ",");
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        int zero = 0;
        Set<String> rs = new HashSet<>();
        ArrayList<Integer> ll1 = new ArrayList<>(), ll2 = new ArrayList<>();
        for (int i : nums) {
            if (i == 0) zero++;
            if (i <= 0) ll1.add(i);
            if (i > 0) ll2.add(i);
        }
        ll1.sort((Integer o1, Integer o2) -> (o1 >= o2 ? (o1.equals(o2) ? 0 : -1) : 1));
        ll2.sort((Integer o1, Integer o2) -> (o1 <= o2 ? (o1.equals(o2) ? 0 : -1) : 1));
        for (Integer i : ll1) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (Integer i : ll2) {
            System.out.print(i + ",");
        }
        System.out.println();

        int i = ll1.size() - 1, j = ll2.size() - 1;
        Integer l1 = 1, l2 = -1, r;
        while (i >= 0 && j >= 0) {
            System.out.println();
            System.out.println();
            l1 = ll1.get(i);
            l2 = ll2.get(j);
            ll1.remove(i);
            ll2.remove(j);
            r = 0 - l1 - l2;
            System.out.println(l1 + "   " + l2 + "   " + r);
            for (Integer a : ll1) {
                System.out.print(a + ",");
            }
            System.out.print("                       ");
            for (Integer b : ll2) {
                System.out.print(b + ",");
            }
            System.out.println();
            if ((r <= 0 && ll1.contains(r)) || (r > 0 && ll2.contains(r))) {
                rs.add(l1 + "," + r + "," + l2);
            }
            if (r <= 0) {
                j--;
                ll1.add(l1);
            } else {
                i--;
                ll2.add(l2);
            }
        }

        Iterator<String> it = rs.iterator();
        String[] its;
        while (it.hasNext()) {
            its = it.next().split(",");
            Integer[] a = {Integer.parseInt(its[0]), Integer.parseInt(its[1]), Integer.parseInt(its[2])};
            result.add(Arrays.asList(a));
        }
        if (result.size() == 0 && nums.length >3 && zero >= 3) {
            Integer[] a = {0, 0, 0};
            result.add(Arrays.asList(a));
        }

        return result;
    }
}
