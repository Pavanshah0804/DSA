import java.util.*;

class Solution {
    public static int compareVersion(String version1, String version2) {
        
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int maxLength = Math.max(s1.length, s2.length);

        for (int i = 0; i < maxLength; i++) {
        
            Integer v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            Integer v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;

            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "1.2";
        String s2 = "1.10";

        // Print the comparison result: negative if s1 < s2, positive if s1 > s2, zero if equal
        System.out.println(compareVersion(s1, s2));
    }
}
