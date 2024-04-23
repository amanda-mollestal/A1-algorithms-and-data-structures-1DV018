package uppgift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointerThreeSum {

  public List<int[]> twoPointerThreeSum(int[] nums) {
    List<int[]> res = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int target = -nums[i];
      int frontPointer = i + 1;
      int backPointer = nums.length - 1;

      while (frontPointer < backPointer) {
        if (nums[frontPointer] + nums[backPointer] == target) {
          res.add(new int[] { nums[i], nums[frontPointer], nums[backPointer] });

          frontPointer++;
          backPointer--;

          while (frontPointer < backPointer && nums[frontPointer] == nums[frontPointer - 1]) {
            frontPointer++;
          }

          while (frontPointer < backPointer && nums[backPointer] == nums[backPointer + 1]) {
            backPointer--;
          }

        } else if (nums[frontPointer] + nums[backPointer] < target) {
          frontPointer++;
        } else {
          backPointer--;
        }
      }
    }
    return res;
  }

}
