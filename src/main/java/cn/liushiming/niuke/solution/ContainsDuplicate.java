package cn.liushiming.niuke.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/8/20 1:30 PM
 * @Version 1.0
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 **/
public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsStr = scanner.nextLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>(nums.length);
        for (Integer num : nums) {
            if (m.containsKey(num)) {
                return true;
            }
            m.put(num, true);
        }
        return false;
    }
}
