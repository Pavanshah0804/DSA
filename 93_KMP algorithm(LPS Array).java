import java.util.ArrayList;

class Solution {

    public static ArrayList<Integer> search(String pat, String txt) {
        int m = pat.length(); 
        int n = txt.length(); 

        // Array to store the longest prefix suffix (LPS) values
        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>(); 
        
        computeLps(pat, m, lps);
        
        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i<n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            // When a match is found, record the starting index
            if (j == m) {
                res.add(i - j + 1); 
                j = lps[j - 1]; // Continue search by resetting pattern index
            }
            // If mismatch occurs after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Reset pattern index using LPS
                } else {
                    i++; // Move to the next character in the text
                }
            }
        }
        return res; 
    }

    public static void computeLps(String pat, int m, int[] lps) {
        int len = 0; // Length of the previous longest prefix suffix
        lps[0] = 0; // LPS of the first character is always 0
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Reset length
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        
        String txt = "ababcababcabc"; 
        String pat = "abc"; 

        ArrayList<Integer> result = search(pat, txt);

        if (result.isEmpty()) {
            System.out.println("Pattern not found");
        } else {
            System.out.println("Pattern found at positions: " + result);
        }
    }
}
