import java.util.*; 

class Solution {
    public static String countAndSay(int n) {
        
        String val = "1"; 
        
        for (int i = 1; i < n; i++) {
            char c = val.charAt(0); 
            StringBuilder s = new StringBuilder(); 
            int count = 0; 
            
            // Loop through the current sequence (val) to construct the next term
            for (int j = 0; j < val.length(); j++) {
                if (c == val.charAt(j)) {
                    count++; // Increment count if the current character matches the previous one
                } else {
                    // Append the count and the character to the StringBuilder when characters change
                    s.append(count);
                    s.append(c);
                    
                    // Reset count for the new character and update c
                    count = 1;
                    c = val.charAt(j);
                }
            }
            
            // After the loop, append the count and character for the last group
            s.append(count);
            s.append(c);
            
            val = s.toString();
        }
        
        return val; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        System.out.println(countAndSay(n)); 
    }
}
