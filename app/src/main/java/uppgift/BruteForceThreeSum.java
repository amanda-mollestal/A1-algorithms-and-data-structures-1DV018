package uppgift;

import java.util.ArrayList;
import java.util.List;

public class BruteForceThreeSum {

  public List<int[]> bruteForceThreeSum(int[] nums) {
    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          if (i == j || i == k || j == k) {
            continue;
          }
          if (nums[i] + nums[j] + nums[k] == 0) {
            res.add(new int[] { nums[i], nums[j], nums[k] });
          }
        }
      }
    }
    return res;
  }
}