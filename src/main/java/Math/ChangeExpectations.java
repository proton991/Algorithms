package Math;

import java.util.HashMap;
import java.util.Map;

public class ChangeExpectations {
    private final Map<Integer, Integer> map = new HashMap<>();

    /**
     *  计算n的阶乘：n! = n * (n-1) * (n-2) * ... *2 * 1
     */
    public long factorial(int n){
        return (n>1) ? n*factorial(n-1) : 1;
    }

    public long combination(int n, int k){
        return (n >= k) ? factorial(n)/(factorial(n-k)*factorial(k)) : 0;
    }
    public double calcE(int[] nums) {
        int n = nums.length;
        double E = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            double p = (double) val / (double) n;
//            System.out.println("p is :" + p);
            E += p * key * val;
        }
        return E;
    }


    public int findWays(int[] nums, double target) {
        int n = nums.length;
        double E = calcE(nums);
        if (E==target) {
            return 0;
        }
        int count = 0;
        if (E > target) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                if (key > 0) {
                    int val = entry.getValue();
                    int key2 = -1 * key;
                    int val2 = map.getOrDefault(key2, 0);
//                    for (int i = 1; i <= val; i++) {
//                        double p = (double) val / (double) n;
//                        double p2 = (double) (val - 1) / (double) n;
//                        double delta1 = (p * key * val) - (p2 * key * (val-1));
//                        int key2 = -1 * key;
//                        int val2 = map.getOrDefault(key2, 0);
//                        double q = (double) val2 / (double) n;
//                        double q2 = (double) (val2 + 1) / (double) n;
//                        double delta2 = (q2 * key2 * (val2+1)) - (q * key2 * val2);
//                        if (delta2 + delta1 == E - target) {
//                            count += combination(val, i);
//                        }
//                    }
                    for (int i = 1; i <= val; i++) {
                        double delta11 = (double) (key * (2 * val * i - i * i)) * key / (double) n;
                        double delta22 = (double) (key2 * (2 * val2 * i + i * i)) * key2 / (double) n;
                        if (Math.abs(delta22) + Math.abs(delta11) == E - target) {
                            count += combination(val, i);
                        }
                    }
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                if (key < 0) {
                    int val = entry.getValue();
                    int key2 = -1 * key;
                    int val2 = map.getOrDefault(key2, 0);
//                    double p = (double) val / (double) n;
//                    double p2 = (double) (val - 1) / (double) n;
//                    double delta1 = (p * key * val) - (p2 * key * (val-1));
//                    int key2 = -1 * key;
//                    int val2 = map.getOrDefault(key2, 0);
//                    double q = (double) val2 / (double) n;
//                    double q2 = (double) (val2 + 1) / (double) n;
//                    double delta2 = (q2 * key2 * (val2+1)) - (q * key2 * val2);
                    for (int i = 1; i <= val; i++) {
                        double delta11 = (double) (key * (2 * val * i - i * i)) * key / (double) n;
                        double delta22 = (double) (key2 * (2 * val2 * i + i * i)) * key2 / (double) n;
                        if (Math.abs(delta22) + Math.abs(delta11) == target - E) {
                            count += combination(val, i);
                        }
                    }
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        ChangeExpectations changeExpectations = new ChangeExpectations();
        int[] nums = {1,1,1,-1,1};
        System.out.println(changeExpectations.findWays(nums, 5.0)==1);

        changeExpectations = new ChangeExpectations();
        int[] nums1 = {1,1,1,1,1};
        System.out.println(changeExpectations.findWays(nums1, 3.0)==5);
    }
}
