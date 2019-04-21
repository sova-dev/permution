import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.04.2019.
 */
public class Solution {

    static int[] nums = {1, 2, 3};

    public static void main(String[] args) {
        List<List<Integer>> permuteList = permute(nums);
        System.out.println(permuteList);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        doPermutation(0, nums, result);
        return result;
    }

    private static void doPermutation(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            doPermutation(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}