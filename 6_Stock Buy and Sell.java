class Solution{
    public static int maxProfit(int []prices){
        if(prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i]< min){
                min = prices[i];
            }
            else if(prices[i]-min>profit){
                profit = prices[i] - min;
            }
            
        }
        return profit;
    }
    
    public static void main(String[] args) {
    int arr[] = {7,1,5,3,6,4};

    int maxPro = maxProfit(arr);
    System.out.println("Max profit is: " + maxPro);
    }
    
}
