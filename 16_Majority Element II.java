import java.util.*;
class Solution{
 
 public static List<Integer> majorityElement(int[] nums){
     int n = nums.length;
     int count1= 0,count2=0;
     int el1=0,el2=0;
     
     for(int i=0;i<n;i++){
         if(count1 == 0 && el2 != nums[i]){
             count1 = 1;
             el1 = nums[i];
         }
         else if(count2 == 0 && el1 != nums[i]){
             count2 = 1;
             el2 = nums[i];
         }
         else if(el1 == nums[i]){
             count1++;
         }
         else if(el2 == nums[i]){
             count2++;
         }
         else{
             count1--;
             count2--;
         }
     }
     
    List<Integer> ans = new ArrayList<>();
     
    count1 = 0;count2 = 0;
    for(int i=0;i<n;i++){
         if(nums[i] == el1) count1++;
         if(nums[i] == el2) count2++;
    }
     
    int min = (int)(n/3)+1;
    if(count1>=min) ans.add(el1);
    if(count2>=min) ans.add(el2);
    
    return ans;
     
 }
 public static void main(String[] args){
     int[] arr = {0,1,1,1,1,2,2,2,2};
     List<Integer> ans = majorityElement(arr);
     System.out.println("The majority elements are: "+ans);
 }   
}
