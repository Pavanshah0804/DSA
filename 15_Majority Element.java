class Solution{
    public static int majorityElement(int[] nums){
        int n = nums.length;
        int element = 0;
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        System.out.println(element);
        int count1= 0;
        for(int i=0;i<n;i++){
            if(nums[i] == element){
                count1++;
            }
        }
        
        if(count1> n/2) return element;
        return -1;
        
    }
    public static void main(String []args){
        int []arr = {2,2,1,1,1,2,2};
        int m = majorityElement(arr);
        System.out.print("majorityElement is "+m);
    }
}