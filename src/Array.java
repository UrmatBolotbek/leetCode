import java.util.ArrayList;
import java.util.List;

public class Array {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public int[] runningSum2(int[] nums) {
        int result[] = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }

    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public List<String> fizzBuzz(int n) {
        List<String> strArray = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                strArray.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strArray.add("Fizz");
            } else if (i % 5 == 0) {
                strArray.add("Buzz");
            } else {
                strArray.add(String.valueOf(i));
            }
        }
        return strArray;
    }

    int step = 0;

    public int numberOfSteps(int num) {
        if (num == 0) {
            return step;
        }
        step++;
        if (num % 2 == 0) {
            numberOfSteps(num / 2);
        } else {
            numberOfSteps(num - 1);
        }
        return step;
    }

    public int numberOfSteps2(int n) {
        int step = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
            step++;
        }
        return step;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
//    public ListNode middleNode(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (alphabets_counter[c - 'a'] == 0)
                return false;
            alphabets_counter[c - 'a']--;
        }
        return true;
    }
}

