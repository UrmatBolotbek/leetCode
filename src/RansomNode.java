import java.util.HashMap;
import java.util.Map;

public class RansomNode {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (alphabets_counter[c - 'a'] == 0){
                return false;
            }
            alphabets_counter[c - 'a']--;
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }
}
