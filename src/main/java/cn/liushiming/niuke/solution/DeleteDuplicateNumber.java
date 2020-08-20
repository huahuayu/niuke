package cn.liushiming.niuke.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shiming
 * @Date 2020/8/3 8:35 PM
 * @Version 1.0
 **/
public class DeleteDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, -1, 0, 0, 0, 3, 3};
        removeDuplicates(nums);
//        mapTest();
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) {
                m.put(nums[i], m.size());
            }
        }

        for (Integer key : m.keySet()) {
            nums[m.get(key)] = key;
        }

        return m.size();
    }

    public static void mapTest() {
        Map<String, String> m = new HashMap<>();
        m.put("name", "zhangsan");
        m.put("gender", "male");
        m.put("age", "18");
        m.put("age", "30");

        System.out.println(m);

        String age = m.get("age");
        System.out.println(age);

        System.out.println(m.containsKey("age"));
        System.out.println(m.containsKey("xx"));
        System.out.println(m.size());

    }
}

