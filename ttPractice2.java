
import java.util.HashSet;
import java.util.Set;

/*
Q1. Does the engagnement_scores has duplicates number?
*/
class Solution{
    public int findMaxSquadSize(int[] arr, int k){
        int maxSquadSize = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i ++){
            set.add(arr[i]);
        }

        for (int es: set){
            // check if es is starting point
            if (set.contains(es - 1)) continue;
            int count = 1;
            while(set.contains(es + count)){
                count ++;
            }

            maxSquadSize = Math.max(maxSquadSize, count);
        }

        return maxSquadSize;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = {12, 14, 15, 11, 16};      // 最長連續序列 1,2,3,4 → 長度 4
        int[] arr2 = {0,3,7,2,5,8,4,6,0,1};       // 最長連續序列 0..8 → 長度 9
        int[] arr3 = {1,1,2,2,3,5,6,7,8,8,9};     // 有重複也 OK

        System.out.println(s.findMaxSquadSize(arr1, 0)); // 4
        System.out.println(s.findMaxSquadSize(arr2, 0)); // 9
        System.out.println(s.findMaxSquadSize(arr3, 0)); // 5 (5..9)
    }
}