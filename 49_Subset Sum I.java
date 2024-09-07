import java.util.*;
class Solution {
    public static void helper(int index, int sum, ArrayList < Integer > arr, int N, ArrayList < Integer > sumSubset) {
        if (index == N) {
            sumSubset.add(sum);
            return;
        }

        helper(index + 1, sum + arr.get(index), arr, N, sumSubset);
        helper(index + 1, sum, arr, N, sumSubset);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {

        ArrayList < Integer > sumSubset = new ArrayList < > ();
        helper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }



    public static void main(String args[]) {

        ArrayList<Integer>arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer>ans = subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i : ans)
            System.out.print(i + " ");
    }

}