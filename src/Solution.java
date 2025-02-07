import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i++));
            merged.append(word2.charAt(j++));
        }

        while (i < word1.length()) {
            merged.append(word1.charAt(i++));
        }

        while (j < word2.length()) {
            merged.append(word2.charAt(j++));
        }

        return merged.toString();
    }

    public static String gcdOfStrings(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            String subString = str1.substring(0, i);
            if (isRepeated(str1, subString) && isRepeated(str2, subString)) {
                return subString;
            }
        }
        return "";
    }

    private static boolean isRepeated(String str, String subString) {
        int len = str.length(), subLen = subString.length();
        if (len % subLen != 0) {
            return false;
        }
        for (int i = 0; i < len; i += subLen) {
            if (!str.substring(i, i + subLen).equals(subString)) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int plot : flowerbed) {
            if (plot == 0) {
                count++;
            }
        }

        if (count == n * 2 + 1) {
            return true;
        }

        return false;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;
        int i = 0;

        while (i < length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }

        return count >= n;
    }

    public String reverseVowels(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            if (!isVowel(chars[i], vowels)) {
                i++;
                continue;
            }
            if (!isVowel(chars[j], vowels)) {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c, char[] vowels) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String word1 = "abczz", word2 = "deft";
        String word3 = "ababab", word4 = "abab";
        System.out.println(mergeAlternately(word1, word2));
        System.out.println(gcdOfStrings(word3, word4));


    }
}
